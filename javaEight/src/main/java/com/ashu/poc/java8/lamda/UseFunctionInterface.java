/**
 * 
 */
package com.ashu.poc.java8.lamda;

import com.ashu.poc.java8.srv.EmployeeService;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
public class UseFunctionInterface {
	public static void firstLambda(int f, int t) {
		IFunInterface fun = (a, b) -> a + b;
		System.out.println(fun.sum(f, t));
		IFunInterface.hi();
		IFunInterface.hello();

	}

	public static void secondLambda() {
		EmployeeService.getListOfEmployeeSorted().forEach((obj) -> System.out.println(obj));
	}

}
