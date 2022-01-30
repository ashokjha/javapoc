/**
 * 
 */
package com.ashu.sbt.bt.bean;

/**
 * @author Ashok Kumar Jha
 *
 */
public class EmployeeDetail {
	private String firstName;
	private String lastName;
	private String email;
	private String employeeId; 

	/**
	 * @param emloyeeId
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public EmployeeDetail(String employeeId, String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.employeeId = employeeId;
	}

	/**
	 * @return the emloyeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param emloyeeId the emloyeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * 
	 */
	public EmployeeDetail() {
		super();
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

	@Override
	public String toString() {
		return String.format(
				"EmployeeDetail [firstName = %s, lastName = %s, email= %s, employeeId= %s]",
				firstName,lastName, email, employeeId);
	}
}
