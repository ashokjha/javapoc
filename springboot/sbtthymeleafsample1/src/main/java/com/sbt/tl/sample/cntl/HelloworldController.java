/**
 * 
 */
package com.sbt.tl.sample.cntl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sbt.tl.sample.ent.Employee;

/**
 * @author Ashok Kumar Jha
 *
 */
@Controller
public class HelloworldController {

	@GetMapping("/ashu/thymeleaf/hello")
	public String hello(Model mdl) {
		mdl.addAttribute("message", "Hello World");
		return "helloworld";

	}

	@GetMapping("/ashu/thymeleaf/jc")
	public String jc() {
		return "samplewithjsandcss";

	}

	@GetMapping("/ashu/thymeleaf/bootstrap")
	public String bts() {
		return "thymeleafwithbootstrapsample";

	}

	@GetMapping("/ashu/thymeleaf/bts")
	public String btsit(Model mdl) {

		List<Employee> emlist = new ArrayList<>();
		emlist.add(new Employee("Tohru", "Watanabe", "t001w@gmail.com"));
		emlist.add(new Employee("Deb", "Gh", "d4567g@gmail.com"));
		emlist.add(new Employee("Ram", "Chat", "r98234c@gmail.com"));
		emlist.add(new Employee("Ml", "Chat", "m5635c@gmail.com"));
		emlist.add(new Employee("Nlg", "Gt", "n334g5665t@gmail.com"));
		emlist.add(new Employee("Ashok Kumar", "Jha", "a5k175@gmail.com"));
		mdl.addAttribute("employees", emlist);
		return "tliteration";
	}
}
