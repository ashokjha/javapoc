/**
 * 
 */
package com.ashu.sbt.thl.srv;

import java.util.List;

import com.ashu.sbt.thl.mdl.Employee;



/**
 * @author Ashok Kumar Jha
 *
 */

public interface IEmployeeService {

	List<Employee> getAllEmployees();
	
	void saveEmployee(Employee empl);

	Employee getEmployeeById(long id);
	
	Employee updateEmployee(Employee empl,long id);
	
	void removeEmployee(long id);

}
