/**
 * 
 */
package com.sbt.tl.sample.ent;

/**
 * @author Ashok Kumar Jha
 *
 */
public class User {
	private String userName;
	private String role;
	private String email;

	/**
	 * @param userName
	 * @param role
	 * @param email
	 */
	public User(String userName, String role, String email) {
		super();
		this.userName = userName;
		this.role = role;
		this.email = email;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
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

}
