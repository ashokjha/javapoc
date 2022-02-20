/**
 * 
 */
package com.ashu.poc.java8.para.stream;

import java.util.stream.IntStream;

import com.ashu.poc.java8.dao.EmployeeDao;
import com.ashu.poc.java8.ent.Employee;

/**
 * @author @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
public class ParallelStreamPoc {
	
	public static void simple() {
		long starttime=System.currentTimeMillis();
		IntStream.range(1, 100).forEach(System.out::println);
		long timeinseq = (System.currentTimeMillis()-starttime);
		starttime=System.currentTimeMillis();
		IntStream.range(1, 100).parallel().forEach(System.out::println);
		long timeinparallel= System.currentTimeMillis()-starttime;
		System.out.println("Time Taken in Sequential = "+ timeinseq +"ms");
		System.out.println("Time Taken in Parallel = "+ timeinparallel+"ms");
		
		//Check the Thread poc
		System.out.println("*********************Sequential***************************");
		IntStream.range(1, 20).forEach(i -> {
			System.out.println("Running by "+ Thread.currentThread().getName()+" value = "+i);
		});
		
		System.out.println("*********************Parallel***************************");

		starttime=System.currentTimeMillis();
		IntStream.range(1, 20).parallel().forEach(i -> {
			System.out.println("Running by "+ Thread.currentThread().getName()+" value = "+i);
		});
	}
	
	
	public static void withBiggerDataset() {
		
		long starttime=System.currentTimeMillis();
		System.out.println("Average Experiance  10000 Employee by Sequential Stream : " 
		    + EmployeeDao.getAllEmployee().stream().map(Employee::getExp)
		    .mapToDouble(i->i).average().getAsDouble());
		long timeinseq = (System.currentTimeMillis()-starttime);
		starttime=System.currentTimeMillis();
		System.out.println("Processing time for 10000 Employee in Parallel Stream :"
		    +EmployeeDao.getAllEmployee().stream().parallel().map(Employee::getExp)
		    .mapToDouble(i->i).average().getAsDouble());
		long timeinparallel= System.currentTimeMillis()-starttime;
		System.out.println("Time Taken in Sequential = "+ timeinseq +"ms");
		System.out.println("Time Taken in Parallel = "+ timeinparallel+"ms");
	}

}
