package com.ashu.poc.java8.ent;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com) SAmple Entity Class
 */

public class Employee {

	private long id;

	private String firstName;

	private String lastName;

	private String email;
	
	private String type;

	private int exp;

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param exp
	 */
	public Employee(long id, String firstName, String lastName, String email, String type, int exp) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.type = type;
		this.exp = exp;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("Employee [id=%d, firstName=%s,lastName=%s , email=%s, type=%s, exp=%d ]", id, firstName, lastName,
				email, type, exp);
	}

	/**
	 * @return the exp
	 */
	public int getExp() {
		return exp;
	}

	/**
	 * @param exp the exp to set
	 */
	public void setExp(int exp) {
		this.exp = exp;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}
