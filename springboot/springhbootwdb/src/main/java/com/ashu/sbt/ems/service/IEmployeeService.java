/**
 * 
 */
package com.ashu.sbt.ems.service;

import java.util.List;

import com.ashu.sbt.ems.model.Employee;

/**
 * @author Ashok Kumar Jha
 *
 */

public interface IEmployeeService {
	
	Employee saveEmployee(Employee empl);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(long id);
	
	Employee updateEmployee(Employee empl,long id);
	
	void removeEmployee(long id);

}
