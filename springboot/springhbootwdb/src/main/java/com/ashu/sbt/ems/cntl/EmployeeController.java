/**
 * 
 */
package com.ashu.sbt.ems.cntl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.sbt.ems.exp.ResourceNotFoundException;
import com.ashu.sbt.ems.model.Employee;

import com.ashu.sbt.ems.service.IEmployeeService;

/**
 * @author Ashok Kumar Jha
 *
 */
@RestController
@RequestMapping("/ashu/api/employees")
public class EmployeeController {

	private IEmployeeService empserv;

	/**
	 * 
	 * @param emp
	 */
	public EmployeeController(IEmployeeService emp) {
		super();
		this.empserv = emp;
	}

	@PostMapping()
	ResponseEntity<Employee> saveEmployee(@RequestBody Employee empl) {
		return new ResponseEntity<Employee>(empserv.saveEmployee(empl), HttpStatus.CREATED);
	}

	@GetMapping()
	List<Employee> getAllEmployee() {
		return empserv.getAllEmployees();
	}

	@GetMapping("{id}")
	ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
		return new ResponseEntity<Employee>(empserv.getEmployeeById(id), HttpStatus.OK);
	}

	@PutMapping("{id}")
	ResponseEntity<Employee> updateEmployee(@RequestBody Employee empl, @PathVariable("id") long id) {
		return new ResponseEntity<Employee>(empserv.updateEmployee(empl, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	ResponseEntity<String> removeEmployee(@PathVariable("id") long id) {
		ResponseEntity<String> re;
		try {
			empserv.removeEmployee(id);
			re = new ResponseEntity<String>(String.format("%s Removed Successfully", id), HttpStatus.OK);
		} catch (ResourceNotFoundException rex) {
			re = new ResponseEntity<String>(rex.getMessage(), HttpStatus.OK);
		}
		return re;
	}

}
