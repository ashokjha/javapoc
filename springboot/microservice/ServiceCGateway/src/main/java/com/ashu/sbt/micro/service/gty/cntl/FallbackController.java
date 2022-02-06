/**
 * 
 */
package com.ashu.sbt.micro.service.gty.cntl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@RestController
public class FallbackController {
	
	@RequestMapping("/paymentSrvFb")
	public Mono<String> paymentSrvFallBallback() {
		return Mono.just("Payment Service is not responding/down please try after sometime");
		
	}

	@RequestMapping("/orderSrvFb")
	public Mono<String> orderSrvFallback() {
		return Mono.just("Order Service is not responding/down please try after sometime");
		
	}
}
