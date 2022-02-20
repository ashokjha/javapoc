/**
 * 
 */
package com.ashu.poc.java8.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.ashu.poc.java8.ent.Employee;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com) Temporary DAO Class
 *
 */
public class EmployeeDao {
	public static List<Employee> getListOfEmployee() {
		return Stream
				.of(new Employee(1, "Ashok Kumar", "Jha", "ashujha@yahoo.co.uk", "A", 22),
						new Employee(2, "Tohru", "Watanabe", "tohruwatanabe@gmail.com", "A", 35),
						new Employee(3, "Mr. Shiroyama", "Taiji", "shiroyamataiji@gmail.com", "A", 32),
						new Employee(6, "Test11", "Remove1", "tr3@gmai3.com", "B", 10),
						new Employee(8, "Ramanedu", "Chatterjee", "r123c5678@gmail.com", "A", 30),
						new Employee(9, "Debashish", "Ghosh", "d3456g5467456@gmail.com", "A", 31))
				.collect(Collectors.toList());

	}

	public static Map<String, Integer> getPmtDataMap() {

		return new HashMap<String, Integer>(
				Map.ofEntries(Map.entry("JAVA", 20), Map.entry("C", 3), Map.entry("C++", 4), Map.entry("PYTHON", 5),
						Map.entry("JavaScript", 20), Map.entry("CSS", 6), Map.entry("HTML", 10), Map.entry("SQL", 15),
						Map.entry("CORBA", 2), Map.entry("SPRING", 10), Map.entry("SCRIPT", 10), Map.entry("Etc", 20)));
	}

	public static Map<Employee, Integer> getEmployeedataMap() {
		// Traditional Comparator
//		Map<Employee, Integer> empData = new TreeMap<>(new Comparator<Employee>() {
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				return o1.getExp() - o2.getExp();
//			}
//		});

		// Lambda
		Map<Employee, Integer> empData = new TreeMap<>((o1, o2) -> o1.getExp() - o2.getExp());

		empData.putAll(
				Map.ofEntries(Map.entry(new Employee(1, "Ashok Kumar", "Jha", "ashujha@yahoo.co.uk", "A", 22), 15),
						Map.entry(new Employee(2, "Tohru", "Watanabe", "tohruwatanabe@gmail.com", "A", 35), 20),
						Map.entry(new Employee(3, "Mr. Shiroyama", "Taiji", "shiroyamataiji@gmail.com", "A", 32), 10),
						Map.entry(new Employee(6, "Test11", "Remove1", "tr3@gmai3.com", "B", 10), 35),
						Map.entry(new Employee(8, "Ramanedu", "Chatterjee", "r123c5678@gmail.com", "A", 30), 25),
						Map.entry(new Employee(9, "Debashish", "Ghosh", "d3456g5467456@gmail.com", "A", 31), 5)));
		return empData;
	}

	public static List<Employee> getAllEmployee() {

		List<Employee> allemp = new ArrayList<Employee>();
		IntStream.range(0, 10000).forEach(i -> allemp.add(new Employee(i, "EMP " + i, "LN " + i, "e" + i + "@emp.com",
				(i % 3 == 0) ? "A" : (i % 3 == 1) ? "B" : "C", i % 1100)));
		System.out.println(allemp.size())
;		return allemp;
	}

}
