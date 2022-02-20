package com.ashu.poc.java8;

import java.util.Arrays;
import java.util.List;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.ashu.poc.java8.cnp.OptionalPoc;

import com.ashu.poc.java8.lamda.UseFunctionInterface;
import com.ashu.poc.java8.mr.MapReducePoc;
import com.ashu.poc.java8.para.stream.ParallelStreamPoc;
import com.ashu.poc.java8.srv.MapAndFlatMapPoc;
import com.ashu.poc.java8.srv.SortingListPoc;
import com.ashu.poc.java8.srv.SortingMapPoc;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
public class JavaEightDriver {
	public static void main(String[] args) {
		System.out.println("###################### Welcome to java 8 POC! ##############################3");
		boolean flag = false;
		if (flag) {
			pocLambda();
			pocConsumerWithLambda();
			pocPredicateWithLambda();
			pocSupplierWithLambda();
			streamPoc();
			mappoc();
			mapAndFlattenMapPoc();
			pocOptional();
			pocMapReduce();

		}

		pocParralelStream();

	}

	/**
	 * 
	 */
	private static void pocParralelStream() {
		ParallelStreamPoc.simple();
		ParallelStreamPoc.withBiggerDataset();
		
	}

	/**
	 * 
	 */
	private static void pocMapReduce() {

		MapReducePoc.basic();
		MapReducePoc.basicWithUserBean();

	}

	public static void pocOptional() {
		// OptionalPoc.optionalPoc();
		OptionalPoc.optionalPoc2();
	}

	public static void mapAndFlattenMapPoc() {
		MapAndFlatMapPoc.checkMapAndFlattenMap();

	}

	public static void mappoc() {
		SortingMapPoc.helloPrimitiveTypeMap();
		SortingMapPoc.helloUdeMap();
	}

	public static void streamPoc() {
		SortingListPoc.traditional();
		SortingListPoc.withStreamAndL();
		SortingListPoc.trdwithStream4NonPrimitive();
		SortingListPoc.trdLambdaNonPrimitive();
		SortingListPoc.trdStreamLambdaFrNonPrimitive();
	}

	/**
	 * Lambda Expression (p1,p2) -> {body} If only one param and one line body p ->
	 * body
	 * 
	 * 
	 */
	public static void pocLambda() {
		UseFunctionInterface.firstLambda(2, 4);
		UseFunctionInterface.secondLambda();

	}

	public static void pocConsumerWithLambda() {
		// Consumer with Lambda
		Consumer<String> consume = a -> System.out.println(a);
		consume.accept("Cool");

		List<String> data = Arrays.asList("Ashok Kumar Jha".split(" "));
		data.forEach(consume);

		Arrays.asList("1 2 3 4 5 6 7 8 9".split(" ")).forEach(a -> System.out.println(a));
	}

	public static void pocPredicateWithLambda() {
		// Predicate with Lambda
		Predicate<Integer> prd = a -> a % 2 == 0;
		System.out.println(prd.test(5));
		System.out.println(prd.test(10));

		Arrays.asList("1,2,30,4,5,6,7,9".split(",")).stream().filter(a -> Integer.valueOf(a) % 2 == 0)
				.forEach(a -> System.out.println("Even : " + a));
	}

	public static void pocSupplierWithLambda() {
		// Supplier with Lambda
		Supplier<List<String>> supp = () -> Arrays.asList("1", "2", "30", "4", "5", "6", "7", "9");

		System.out.println(supp.get());

		supp.get().stream().filter(a -> Integer.valueOf(a) % 2 == 0).forEach(a -> System.out.println("Even : " + a));
		System.out.println(
				supp.get().stream().filter(a -> Integer.valueOf(a) % 46 == 0).findAny().orElseGet(() -> "Not Exist"));
	}

}
