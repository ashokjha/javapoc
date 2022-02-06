/**
 * 
 */
package com.ashu.sbt.micro.service.order.service.dto.bean;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */

public class Payment {

	private int paymentId;
	private String paymentStatus;
	private String transactionId;
	private double amount;
	private int orderId;

	/**
	 * Default
	 */
	public Payment() {
		super();
	}

	/**
	 * @param paymentId
	 * @param paymentStatus
	 * @param transactionId
	 */
	public Payment(int paymentId, String paymentStatus, String transactionId, double amount, int orderId) {
		super();
		this.paymentId = paymentId;
		this.paymentStatus = paymentStatus;
		this.transactionId = transactionId;
		this.amount = amount;
		this.orderId = orderId;
	}

	/**
	 * @return the paymentId
	 */
	public int getPaymentId() {
		return paymentId;
	}

	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * @return the paymentStatus
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}

	/**
	 * @param paymentStatus the paymentStatus to set
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
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
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Payment [paymentId =" + paymentId + ", paymentStatus =" + paymentStatus + ", transactionId ="
				+ transactionId + ", amount =" + amount + ", orderId =" + orderId + "]";
	}

}
