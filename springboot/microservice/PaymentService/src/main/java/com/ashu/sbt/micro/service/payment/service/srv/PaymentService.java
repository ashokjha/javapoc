/**
 * 
 */
package com.ashu.sbt.micro.service.payment.service.srv;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashu.sbt.micro.service.payment.service.ent.Payment;
import com.ashu.sbt.micro.service.payment.service.repo.IPaymentRepository;

/**
 * @author Ashok Kumar Jha
 *
 */
@Service
public class PaymentService {

	@Autowired
	private IPaymentRepository payrepo;

	public Payment makePayment(Payment payment) {
		payment.setTransactionId(UUID.randomUUID().toString());
		payment.setPaymentStatus(paymentStatus(payment));
		
		return payrepo.save(payment);
	}

	public List<Payment> queryAllPayment() {
		return payrepo.findAll();
	}
	
	public String paymentStatus(Payment payment) {
		// Does Payment using any third party party like Paypal, Paytm etc
		// gateway for payment and use accordingly payment status
		return (new Random()).nextBoolean()?"SUCCESSFUL":"FAIL";
	}
}
