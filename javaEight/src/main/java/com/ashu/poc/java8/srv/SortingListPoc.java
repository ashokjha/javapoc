/**
 * 
 */
package com.ashu.poc.java8.srv;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ashu.poc.java8.dao.EmployeeDao;
import com.ashu.poc.java8.ent.Employee;


/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com) Temporary Service Class
 *
 */
public class SortingListPoc {

	public static void traditional() {
		System.out.println("Tradinional plain vanilla");
		List<Integer> numList = Arrays.asList(15, 1, 2, 10, 5, 8, 3, 4, 7, 12);
		System.out.println(numList);
		Collections.sort(numList);
		System.out.println(numList);// Asc

		Collections.reverse(numList);
		System.out.println(numList);// Desc
	}

	/**
	 * Sorting using Stream Lambda and Default comparator For Ascending Lambda For
	 * Descending with Comparator
	 */
	public static void withStreamAndL() {
		System.out.println("With Stream Lamda and comparator ");

		List<Integer> numList = Arrays.asList(15, 1, 2, 10, 5, 8, 3, 4, 7, 12);
		System.out.println("Original :" );
		numList.forEach(System.out::println);
		// Ascending
		System.out.println("Asscending");
		numList.stream().sorted().forEach(e -> System.out.println(e));

		// Descending

		System.out.println("Descending");
		numList.stream().sorted(Comparator.reverseOrder()).forEach(e -> System.out.println(e));

		// Above two works for Primitive data type only , For custom class we need to
		// provide the comparator

	}

	/**
	 * Traditional Sorting using Stream Lambda and comparator for non primitive For
	 * Ascending using comparator For Descending with Comparator as anonymous
	 */
	public static void trdwithStream4NonPrimitive() {
		System.out.println("With Stream Lamda and comparator ");

		List<Employee> empList = EmployeeDao.getListOfEmployee();
		System.out.println("Original :" );
		empList.forEach(System.out::println);
		// Ascending
		System.out.println("traditional Descending");
		Collections.sort(empList, new EmployeeComprator());

		empList.forEach(System.out::println);

		System.out.println("Ascending with annonymus comparator");

		Collections.sort(empList, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return (int) (o1.getId() - o2.getId());
			}
		});

		empList.forEach(System.out::println);
	}

	/**
	 * Sorting using Lambda and FI for non primitive
	 * 
	 */
	public static void trdLambdaNonPrimitive() {
		System.out.println("With Lambda  trdLamdaNonPrimitive ");
		List<Employee> empList = EmployeeDao.getListOfEmployee();
		System.out.println("Original :");
		empList.stream().forEach(e -> System.out.println(e));
		// Ascending
		System.out.println("Lambda Sorting Ascending");
		Collections.sort(empList, (o1, o2) -> o1.getExp() - o2.getExp());
		empList.stream().forEach((a) -> System.out.println(a));
		// Descending
		System.out.println("Lambda Sorting Descending");
		Collections.sort(empList, (o1, o2) -> o2.getExp() - o1.getExp());
		empList.stream().forEach((a) -> System.out.println(a));

		// Descending
		System.out.println("Lambda Sorting Descending");
		Collections.sort(empList, (o1, o2) -> o2.getExp() - o1.getExp());
		empList.stream().forEach((a) -> System.out.println(a));
	}

	/**
	 * Sorting using Stream Lambda and Function Reference for non primitive
	 * 
	 */
	public static void trdStreamLambdaFrNonPrimitive() {
		System.out.println("trdStreamLambdaFrNonPrimitive");
		List<Employee> empList = EmployeeDao.getListOfEmployee();
		System.out.println("##############################Original##############################");
		empList.stream().forEach(System.out::println);
		// Ascending
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@Ascending@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		empList.stream().sorted((o1, o2) -> o1.getExp() - o2.getExp()).forEach(System.out::println);

		// Descending
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%Descending%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		empList.stream().sorted((o1, o2) -> o2.getExp() - o1.getExp()).forEach((e) -> System.out.println(e));


		// Function Reference with Lambda
		System.out.println("$$$$$$$$With Lambda of Function Reference default ascending$$$$$$$$");
		empList.stream().sorted(Comparator.comparing(empl -> empl.getFirstName())).forEach(System.out::println);
		// Function Reference with Lambda
		System.out.println("$$$$$$$$With Function Reference default ascending$$$$$$$$");
		empList.stream().sorted(Comparator.comparing(Employee::getLastName)).forEach(System.out::println);
	
	}

}

class EmployeeComprator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return (int) (o2.getId() - o1.getId());
	}

}
