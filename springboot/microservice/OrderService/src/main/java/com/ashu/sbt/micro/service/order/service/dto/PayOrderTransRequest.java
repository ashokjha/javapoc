/**
 * 
 */
package com.ashu.sbt.micro.service.order.service.dto;

import com.ashu.sbt.micro.service.order.service.dto.bean.Payment;
import com.ashu.sbt.micro.service.order.service.ent.Order;

/**
 * @author Ashok Kumar Jha
 *
 */
public class PayOrderTransRequest {
	private Order order;
	private Payment payment;
	
	/**
	 * @param order
	 * @param payment
	 */
	public PayOrderTransRequest(Order order, Payment payment) {
		super();
		this.order = order;
		this.payment = payment;
	}

	/**
	 * 
	 */
	public PayOrderTransRequest() {
		super();
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}
