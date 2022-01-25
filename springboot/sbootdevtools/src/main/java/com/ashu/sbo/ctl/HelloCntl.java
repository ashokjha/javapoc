package com.ashu.sbo.ctl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.sbo.mdl.Student;



@RestController
public class HelloCntl {

	@GetMapping("/ashu")
	public String hello() {
		return "Hello World From Ashok Kumar Jha email: ashu.kr.jha@gmail.com";
	}

	@GetMapping("/ashu/student")
	public Student getStudent() {
		return new Student("Shriyans", "Bhaumik", "XII");
	}

	@GetMapping("/ashu/students")
	public List<?> getStudents() {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("Shriyans", "Bhaumik", "XII"));
		list.add(new Student("Abhiroop", "Das", "XII"));
		list.add(new Student("Sujit", "Nath", "X"));
		list.add(new Student("Arpita", "Gosh", "XII"));
		list.add(new Student("Aaditya", "Banerjee", "XII"));
		list.add(new Student("Sanjay", "Tiwari", "XI"));
		list.add(new Student("Anikma", "ChaterJee", "X"));
		list.add(new Student("Rakesh", "Jha", "XII"));
		list.add(new Student("Prithwis", "Chanda", "BathroomCleaner"));
		return list;
	}

	
	/**
	 * Sample of path annotation/ Variable Uses
	 * Sample: http://localhost:8080/ashu/student/Anu/G/XVII
	 * @param firstName
	 * @param lastName
	 * @param level
	 * @return Student
	 */
	@GetMapping("/ashu/student/{f}/{l}/{c}")
	public Student getStudentP(@PathVariable("f") String firstName, 
			@PathVariable("l") String lastName, 
			@PathVariable("c") String level) {
		return new Student(firstName, lastName, level);
	}
	
	/**
	 * Sample of Query Param annotation Uses
	 * Sample: http://localhost:8080/ashu/student/q?f=Mal&l=Das&c=XV
	 * @param firstName
	 * @param lastName
	 * @param level
	 * @return Student
	 */
	@GetMapping("/ashu/student/q")
	public Student getStudentDetail(@RequestParam(name="f") String firstName, 
			@RequestParam(name="l") String lastName, 
			@RequestParam(name="c") String level) {
		return new Student(firstName, lastName, level);
	}
}
