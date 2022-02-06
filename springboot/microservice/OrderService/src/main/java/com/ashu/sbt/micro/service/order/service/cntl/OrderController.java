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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@RestController
@RequestMapping("/ashu/order")

public class OrderController {

	private static final String PAYMENT_SERVICE = "paymentService";

	@Autowired
	private OrderService ors;

	@Autowired
	RestTemplate rstmp;

	@PostMapping("/bs")
	@CircuitBreaker(name = PAYMENT_SERVICE, fallbackMethod = "paymentSrvFallback")
	public PayOrderTransRespose BookOrder(@RequestBody PayOrderTransRequest req) {
		String successMessage = "Order Booked and Paid Successfully";
		String failMessage = "Order Booked and Payment Failed";
		Order order = req.getOrder();
		ors.saveOrder(order);
		Payment payment = req.getPayment();
		payment.setAmount(order.getPrice());
		payment.setOrderId(order.getId());
		Payment pay = rstmp.postForObject("http://PAYMENT-SERVICE/ashu/payment/pay", payment, Payment.class);
		PayOrderTransRespose potr = new PayOrderTransRespose(order, pay.getAmount(), pay.getTransactionId(),
				(pay.getPaymentStatus().equalsIgnoreCase("SUCCESSFUL") ? successMessage : failMessage));
		return potr;
	}

	@PostMapping("/qor")
	public List<Order> getAllOrder() {
		return ors.fetchAllOrder();
	}

	public PayOrderTransRespose paymentSrvFallback(@RequestBody PayOrderTransRequest req, Exception ex) {
		return new PayOrderTransRespose(req.getOrder(), req.getOrder().getPrice(), "", "Payment Service is down");
	}

}
