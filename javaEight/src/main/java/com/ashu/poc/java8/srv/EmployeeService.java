/**
 * 
 */
package com.ashu.poc.java8.srv;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.ashu.poc.java8.dao.EmployeeDao;
import com.ashu.poc.java8.ent.Employee;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com) Temporary Service Class
 *
 */
public class EmployeeService {

	/**
	 * @return (obj1,obj2) -> obj1.getFirstName().compareTo(obj2.getFirstName());
	 */
	public static List<Employee> getListOfEmployeeSorted() {
		List<Employee> emplist = EmployeeDao.getListOfEmployee();
		emplist.forEach((a) -> System.out.println(a));
		Collections.sort(emplist, (a, b) -> a.getFirstName().compareTo(b.getFirstName()));
		System.out.println("Sorting Done");
		return emplist;
	}

	public static Optional<Employee> getEmployeeByLastName(String ln) {
		return EmployeeDao.getListOfEmployee().stream().
				filter(emp -> emp.getLastName().equalsIgnoreCase(ln)).findAny();

	}
}
