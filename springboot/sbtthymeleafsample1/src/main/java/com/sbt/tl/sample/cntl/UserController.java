/**
 * 
 */
package com.sbt.tl.sample.cntl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sbt.tl.sample.ent.User;

/**
 * @author Ashok Kumar Jha
 *
 */

@Controller
public class UserController {

	@GetMapping("/ashu/thymeleaf/iu")
	public String checkifunless(Model mdl) {
		List<User> usrList = new ArrayList<>();
		usrList.add(new User("Tohru Watanabe", "ADMIN", "t001w@gmail.com"));
		usrList.add(new User("Deb Gh", "ADMIN", "d4567g@gmail.com"));
		usrList.add(new User("Ram Chat", "ADMIN", "r98234c@gmail.com"));
		usrList.add(new User("Ml Chat", "MANAGER", "m5635c@gmail.com"));
		usrList.add(new User("Nlg Gt", "GUEST", "n334g5665t@gmail.com"));
		usrList.add(new User("Ashok Kumar Jha", "ADMIN", "a5k175@gmail.com"));
		usrList.add(new User("Gout Dy", "OTHER", "g5d175@gmail.com"));
		mdl.addAttribute("users", usrList);
		return "ifunlesssample";
	}

	@GetMapping("/ashu/thymeleaf/sc")
	public String checkswitchcase(Model mdl) {
		User user = new User("Kausik Saha", "ADMIN", "k5s173@gmail.com");
		mdl.addAttribute("user", user);
		return "switchcase";
	}
}
