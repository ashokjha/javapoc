package com.ashu.poc.java8.cnp;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.ashu.poc.java8.ent.Books;
import com.ashu.poc.java8.ent.Employee;
import com.ashu.poc.java8.srv.EmployeeService;

/**
 * @author shok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
public class OptionalPoc {

	public static void optionalPoc() {
		Books bk = new Books(4, "Close to the Machine", "Ellen Ullman", null);
		Books bk2 = new Books(14, "Ghost in the Wires", "Kevin Mitnick", List.of("210000", "960023"));

		Optional<Object> emptyOptional = Optional.empty();
		System.out.println("Empty Optional => " + emptyOptional);

		Optional<List<String>> ofOptional = Optional.of(bk2.getPhones());
		System.out.println("of optional =>" + ofOptional);

		// Below will throw NullPointer Exception so commenting
		// ofOptional = Optional.of(bk.getPhones());
		// System.out.println("of optional =>" + ofOptional);

		Optional<List<String>> ofNullableOptional = Optional.ofNullable(bk.getPhones());
		if (ofNullableOptional.isPresent())
			System.out.println("of optional nullable =>" + ofNullableOptional.get());

		Optional<List<String>> ofNullableOptional1 = Optional.ofNullable(bk2.getPhones());
		if (ofNullableOptional.isPresent())
			System.out.println("of optional nullable =>" + ofNullableOptional1.get());

		// optional with or else
		System.out.println(ofNullableOptional.orElse(Collections.emptyList()));
		System.out.println(ofNullableOptional1.orElse(Collections.emptyList()));
		// orElseThrow can be used make it mandatory

		Employee emp1 = new Employee(6, "F_n", null, "F_N@F_N.com","A", 10);
		Employee emp2 = new Employee(6, "F_n", "L_n", "F_NL_N@F_NL_N.com", "A", 10);
		Optional<String> empLnOpt1 = Optional.ofNullable(emp1.getLastName());
		Optional<String> empLnOpt2 = Optional.ofNullable(emp2.getLastName());
		System.out.println(empLnOpt1.orElse("Last Name Not present"));
		System.out.println(empLnOpt2.orElse("Last Name Not present"));
		System.out.println(empLnOpt1.orElseGet(() -> "Last Name Not present"));
		System.out.println(empLnOpt2.orElseGet(() -> "Last Name Not present"));
		System.out.println(empLnOpt2.orElseThrow(() -> new IllegalArgumentException("Last Name Not present")));
		System.out.println(empLnOpt1.orElseThrow(() -> new IllegalArgumentException("Last Name Not present")));
	}

	public static void optionalPoc2() {
		// Below line if not present will throw no value present exception
		EmployeeService.getEmployeeByLastName("ABC").ifPresentOrElse(e -> System.out.println(e),
				() -> System.out.println("Not Present"));
		EmployeeService.getEmployeeByLastName("Ghosh").ifPresentOrElse(e -> System.out.println(e),
				() -> System.out.println("Not Present"));
	}

}
