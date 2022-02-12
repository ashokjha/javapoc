/**
 * 
 */
package com.ashu.sbt.micro.service.msg.bean;


/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */


public class Order {

	private int id;
	private String name;
	private int quantity;
	private double price;

	
	/**
	 * 
	 */
	public Order() {
		super();
	}


	/**
	 * @param id
	 * @param name
	 * @param quantity
	 * @param price
	 */
	public Order(int id, String name, int quantity, double price) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}


	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "{'id':" + id + ", 'name':'" + name + "', 'quantity':" + quantity + ", 'price':" + price + "}";
	}	
}
