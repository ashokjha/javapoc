/**
 * 
 */
package com.ashu.sbt.thl.cntl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashu.sbt.thl.mdl.Employee;
import com.ashu.sbt.thl.srv.IEmployeeService;

/**
 * @author Ashok Kumar Jha
 *
 */
@Controller
@RequestMapping("/ashu/emp")
public class EmployeeController {

	@Autowired
	IEmployeeService empserv;

	@GetMapping("/")
	String getAllEmployee(Model mdl) {
		mdl.addAttribute("employeeList", empserv.getAllEmployees());
		return "index";
	}

	@GetMapping("/createEmployee")
	String createEmployee(Model mdl) {
		Employee emp = new Employee();
		mdl.addAttribute("employee", emp);
		return "newEmployee";
	}

	@PostMapping("/saveEmployee")
	String saveEmployee(@ModelAttribute("employee") Employee emp) {
		empserv.saveEmployee(emp);
		return "redirect:/ashu/emp/";
	}

	@GetMapping("/empUpdate/{id}")
	String showForUpdate(@PathVariable("id") long id, Model mdl) {
		Employee emp = empserv.getEmployeeById(id);
		mdl.addAttribute("employee", emp);
		return "updateEmployee";
	}

	@PostMapping("/updateEmployee")
	String updateEmployee(@ModelAttribute("employee") Employee emp) {
		empserv.updateEmployee(emp, emp.getId());
		return "redirect:/ashu/emp/";
	}

	@GetMapping("/removeEmp/{id}")
	String removeEmployee(@PathVariable("id") long id) {
		empserv.removeEmployee(id);
		return "redirect:/ashu/emp/";
	}
}
