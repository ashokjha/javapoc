/**
 * 
 */
package com.ashu.sbt.micro.service.order.service.dto;

import com.ashu.sbt.micro.service.order.service.ent.Order;

/**
 * @author Ashok Kumar Jha
 *
 */
public class PayOrderTransRespose {
	private Order order;
	private double amount;
	private String transactionId;
	private String message;

	/**
	 * 
	 */
	public PayOrderTransRespose() {
		super();
	}

	/**
	 * @param order
	 * @param amount
	 * @param transactionId
	 */
	public PayOrderTransRespose(Order order, double amount, String transactionId, String message) {
		super();
		this.order = order;
		this.amount = amount;
		this.transactionId = transactionId;
		this.message = message;
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
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
