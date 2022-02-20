/**
 * 
 */
package com.ashu.poc.java8.dao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ashu.poc.java8.ent.Books;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com) Sample DAO
 *
 */
public class BookDao {

	public static List<Books> getBookList() {
		return Stream
				.of(new Books(1, "The C++ Programming Language", "Bjarne Stroustrup", List.of("234456", "987656")),
						new Books(2, "The Practice of Programming", "Brian W. Kernighan, Rob Pike",
								List.of("603434", "3356")),
						new Books(3, "The Art of Computer Programming", "Donald Knuth", List.of("4456", "9656")),
						new Books(4, "Close to the Machine", "Ellen Ullman", List.of("09087234456")),
						new Books(5, "Fundamentals of Computer Algorithms", "Ellis Horowitz",
								List.of("20834456", "987656")),
						new Books(6, "The Art of Unix Programming", "Eric Raymond", List.of("234456", "987656")),
						new Books(7, "The Psychology of Computer Programming", "Gerald M. Weinberg",
								List.of("234456", "987656")),
						new Books(8, "The Java Programming Language", "James Gosling", List.of("234456", "9876565680")),
						new Books(9, "The Best Software Writing I", "Joel Spolsky", List.of("23401456", "987087656")),
						new Books(10, "After the Software Wars", "Keith Curtis", List.of("2034456", "9876556")),
						new Books(11, "Free Software, Free Society", "Richard M. Stallman",
								List.of("230774456", "98017656")),
						new Books(12, "Patterns of Software", "Richard P. Gabriel", List.of("1234456", "98709656")),
						new Books(13, "Innovation Happens Elsewhere", "Richard P. Gabriel",
								List.of("23490456", "98007656")),
						new Books(14, "Ghost in the Wires", "Kevin Mitnick", List.of("210000", "960023")))
				.collect(Collectors.toList());

	}
}
