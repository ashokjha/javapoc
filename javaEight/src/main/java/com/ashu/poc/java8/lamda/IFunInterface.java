/**
 * 
 */
package com.ashu.poc.java8.lamda;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@FunctionalInterface
public interface IFunInterface {
	int sum(int f, int t);

	public static void hi() {
		System.out.println("Hi");
	}

	public static void hello() {
		System.out.println("POC for LAMDA");
	}
}
