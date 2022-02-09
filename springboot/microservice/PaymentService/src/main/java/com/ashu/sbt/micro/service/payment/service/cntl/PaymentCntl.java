/**
 * 
 */
package com.ashu.sbt.micro.service.payment.service.cntl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.sbt.micro.service.payment.service.ent.Payment;
import com.ashu.sbt.micro.service.payment.service.srv.PaymentService;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@RestController
@RequestMapping("/ashu/payment")
@RefreshScope
public class PaymentCntl {
	private static final Logger log = LoggerFactory.getLogger(PaymentCntl.class);

	@Autowired
	private PaymentService pmsrv;

	@PostMapping("/pay")
	public Payment doPayment(@RequestBody Payment payment) {
		log.info(payment.toString());
		return pmsrv.makePayment(payment);
	}

	@PostMapping("/qrp")
	public List<Payment> allPayment() {
		return pmsrv.queryAllPayment();
	}
}
