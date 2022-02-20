/**
 * 
 */
package com.ashu.poc.java8.srv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.ashu.poc.java8.dao.EmployeeDao;
import com.ashu.poc.java8.ent.Employee;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
public class SortingMapPoc {

	/**
	 * For primitive data type Map
	 */
	public static void helloPrimitiveTypeMap() {
		System.out.println("This is for POC of Map for each tradional, lambda, stream, and others");
		// Print
		System.out.println("##############################1###################################");
		EmployeeDao.getPmtDataMap().entrySet()
				.forEach(elm -> System.out.println(elm.getKey() + " -> " + elm.getValue()));
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		EmployeeDao.getPmtDataMap().entrySet().forEach(System.out::println);
		List<Entry<String, Integer>> entset = new ArrayList<Entry<String, Integer>>(
				EmployeeDao.getPmtDataMap().entrySet());
		System.out.println("&&&&&& Traditional Sorting with comprators and lamda &&&&&&");
		Collections.sort(entset, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
		entset.forEach(System.out::println);

		System.out.println("++++++ Sorting with stream, lamda,FI +++++++");
		EmployeeDao.getPmtDataMap().entrySet().stream().sorted((o1, o2) -> o2.getKey().compareTo(o1.getKey()))
				.forEach(System.out::println);

		System.out.println("++++++ Sorting with stream, FI +++++++");
		EmployeeDao.getPmtDataMap().entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEach(System.out::println);
		System.out.println("++++++ Sorting with stream, FI +++++++");
		EmployeeDao.getPmtDataMap().entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		System.out.println(
				"All of above works for primitive only.  In custom data type next we need to provide properties mentioned in next method  ");

	}

	/**
	 * For User Defined Data type Map
	 */
	public static void helloUdeMap() {
		System.out.println("This is for POC of Map for each tradional, lambda, stream, and others");
		// Print
		System.out.println("##############################1###################################");
		EmployeeDao.getEmployeedataMap().entrySet()
				.forEach(elm -> System.out.println(elm.getKey() + " -> " + elm.getValue()));
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		// Using Stream sort with method Reference
		System.out.println("############# Using Stream sort with method Reference ###########");
		EmployeeDao.getEmployeedataMap().entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getFirstName).reversed()))
				.forEach(System.out::println);

	}
}
