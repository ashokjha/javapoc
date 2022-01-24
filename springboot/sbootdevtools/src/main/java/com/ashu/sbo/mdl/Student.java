/**
 * 
 */
package com.ashu.sbo.mdl;

/**
 * 
 * @author Ashok Kumar Jha
 *
 */
public class Student {
	
	String firstName;
	String lastName;
	String currentClass;
	/**
	 * @param firstName
	 * @param lastName
	 * @param currentClass
	 */
	public Student(String firstName, String lastName, String currentClass) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.currentClass = currentClass;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCurrentClass() {
		return currentClass;
	}
	public void setCurrentClass(String currentClass) {
		this.currentClass = currentClass;
	}
}
