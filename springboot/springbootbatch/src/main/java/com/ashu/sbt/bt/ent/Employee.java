/**
 * 
 */
package com.ashu.sbt.bt.ent;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ashok Kumar Jha
 *
 */

@Document(collection = "employee")
public class Employee {

	@Id
	private String id;
	@NotNull(message = "User's first name must not be null")
	private String firstName;
	private String lastName;
	private String email;
	@NotEmpty(message = "Employee's ID must not be null")
	private String employeeId;

	@CreatedDate
	private LocalDateTime createdDate;
	@LastModifiedDate
	private LocalDateTime lastModifieDate;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the createdDate
	 */
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastModifieDate
	 */
	public LocalDateTime getLastModifieDate() {
		return lastModifieDate;
	}

	/**
	 * @param lastModifieDate the lastModifieDate to set
	 */
	public void setLastModifieDate(LocalDateTime lastModifieDate) {
		this.lastModifieDate = lastModifieDate;
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

	@Override
	public String toString() {
		return String.format(
				"Employee [id= %s, employeeId = %s, firstName=%s, lastName= %s , email=%s , createdDate= %s , lastModifieDate= %s ]", id,
				employeeId, firstName, lastName, email, createdDate, lastModifieDate);
	}

}
