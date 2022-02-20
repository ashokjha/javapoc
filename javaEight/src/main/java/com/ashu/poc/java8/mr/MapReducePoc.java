/**
 * 
 */
package com.ashu.poc.java8.mr;

import java.util.Arrays;
import java.util.List;

import com.ashu.poc.java8.dao.EmployeeDao;
import com.ashu.poc.java8.ent.Employee;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
public class MapReducePoc {

	public static void basic() {
		List<Integer> numlist = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println("sum 1 to 10 using aggregate i.e. sum = " + numlist.stream().mapToInt(i -> i).sum());
		System.out.println("Sum of 1 to 10 using reduce = " + numlist.stream().reduce(Integer::sum).get());
		System.out.println("Multiply of 1 to 10 using reduce = " + numlist.stream().reduce((a, b) -> a * b).get());
		System.out.println("Min of 1 to 10 using reduce = " + numlist.stream().reduce(Integer::min).get());
		System.out.println("Max of 1 to 10 using reduce = " + numlist.stream().reduce(Integer::max).get());
		System.out.println("Average of 1 to 10 using reduction method average = "
				+ numlist.stream().mapToDouble(i -> i).average().getAsDouble());
	}

	/**
	 * Poc for Supplier Stream Filter Map Reduce
	 * 
	 */
	public static void basicWithUserBean() {
		
		// Logic
		// 1. Get Data 2. Change to stream 3.Filter (predicate) 4.Map 5. reduce
		System.out.println(String.format("Average Experiance of \"A\" Type Emplyee = %f",
				EmployeeDao.getListOfEmployee().stream().filter((e) -> e.getType().equalsIgnoreCase("A"))
						.map(Employee::getExp).mapToDouble(i -> i).average().getAsDouble()));
		
        //Sum of experience of Type 'A' Employee 
		System.out.println(String.format("Sum of Experiance of \"A\" Type Emplyee = %d",
				EmployeeDao.getListOfEmployee().stream().filter((e) -> e.getType().equalsIgnoreCase("A"))
						.map(Employee::getExp).mapToInt(i->i).sum()));
	}
}
