/**
 * 
 */
package com.ashu.poc.java8.srv;

import java.util.List;
import java.util.stream.Collectors;

import com.ashu.poc.java8.dao.BookDao;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com) Sample of Map and flatten map
 *         with stream
 *
 * Map -> Data Transformation
 * FlatMap-> Transformation + Flattering 
 */
public class MapAndFlatMapPoc {

	public static void checkMapAndFlattenMap() {
		System.out.println("############## Use map when 1 to one relation##################");
		List<String> autherList = BookDao.getBookList().stream().map(book -> book.getAuther())
				.collect(Collectors.toList());
		
		System.out.println(autherList);
		
		// Using Map List of List  for 1-1 mapping go for map 
		List<List<String>> phones = BookDao.getBookList().stream().map(book -> book.getPhones())
				.collect(Collectors.toList());
		System.out.println("############## Use map problem when 1 to manny relation##################");
		System.out.println(phones);

		// Using flat Map during 1-many flattening 
		System.out.println("@@@@@@@@@@@@@@@@@@ Use flatmap during flatening for 1 to many relation");
		List<String> flphones = BookDao.getBookList().stream().flatMap(t ->t.getPhones().stream()).collect(Collectors.toList());
		
		System.out.println(flphones);
	}
}
