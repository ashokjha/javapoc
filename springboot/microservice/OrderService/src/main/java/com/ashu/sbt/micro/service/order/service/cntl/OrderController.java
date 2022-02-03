/**
 * 
 */
package com.ashu.sbt.micro.service.order.service.cntl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ashu.sbt.micro.service.order.service.dto.bean.Payment;
import com.ashu.sbt.micro.service.order.service.dto.PayOrderTransRequest;
import com.ashu.sbt.micro.service.order.service.dto.PayOrderTransRespose;
import com.ashu.sbt.micro.service.order.service.ent.Order;
import com.ashu.sbt.micro.service.order.service.srv.OrderService;

/**
 * @author Ashok Kumar Jha
 *
 */
@RestController
@RequestMapping("/ashu/order")
public class OrderController {

	@Autowired
	private OrderService ors;

	@Autowired
	RestTemplate rstmp;

	@PostMapping("/bs")
	public PayOrderTransRespose BookOrder(@RequestBody PayOrderTransRequest req) {
		String successMessage = "Order Booked and Paid Successfully";
		String failMessage = "Order Booked and Payment Failed";
		Order order = req.getOrder();
		ors.saveOrder(order);
		Payment payment = req.getPayment();
		payment.setAmount(order.getPrice());
		payment.setOrderId(order.getId());
		// Eureka API Call help in url hardcoding
		Payment pay =  rstmp.postForObject("http://PAYMENT-SERVICE/ashu/payment/pay", payment, Payment.class);
		
		//This will be done by Hystrix
		PayOrderTransRespose potr = new PayOrderTransRespose(order,
				pay.getAmount(),
				pay.getTransactionId(),
				(pay.getPaymentStatus().equalsIgnoreCase("SUCCESSFUL")?
						successMessage:failMessage)); 
		return potr;
	}

	@PostMapping("/qor")
	public List<Order> getAllOrder() {
		return ors.fetchAllOrder();
	}

}
