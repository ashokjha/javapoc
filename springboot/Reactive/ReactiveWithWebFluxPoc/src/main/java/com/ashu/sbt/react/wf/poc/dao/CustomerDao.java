/**
 * 
 */
package com.ashu.sbt.react.wf.poc.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.ashu.sbt.react.wf.poc.dto.Customer;

import reactor.core.publisher.Flux;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@Component
public class CustomerDao {

    /**
     * Sleep
     * 
     * @param i
     */
    public static void sleepExecution(long i) {
        try {
            System.out.println(i);
            Thread.sleep(1000);
        } catch (InterruptedException exp) {
            exp.printStackTrace();
        }
    }

    /**
     * Traditional Approach delay added to show the concept of reactive
     * 
     * @return List of Customers
     */
    public List<Customer> getListOfCustomers() {
        return IntStream.rangeClosed(1, 100).peek(CustomerDao::sleepExecution)
                .peek(i -> System.out.println("Processing Customer " + i))
                .mapToObj(i -> new Customer(i, "Customer" + i))
                .collect(Collectors.toList());
    }

    /**
     * Get List of Customers as a Flux
     * 
     * @return List of Customers
     */
    public Flux<Customer> getFluxofCustomers() {
        return Flux.range(1, 100).map(i -> new Customer(i, "Customer" + i));
    }

    /**
     * Reactive Approach
     * 
     * @return Flux of Customers
     */
    public Flux<Customer> getListOfCustomersStream() {
        return Flux.range(1, 100).delayElements(Duration.ofMillis(1000))
                .doOnNext(i -> System.out.println("Processing Customer " + i))
                .map(i -> new Customer(i, "Customer" + i));
    }

    /**
     * Reactive Approach
     * 
     * @return Flux of Customers
     */
    public Flux<Customer> getListOfCustomersForHandler() {
        return Flux.range(1, 100)
                .doOnNext(i -> System.out.println("Processing Customer " + i))
                .map(i -> new Customer(i, "Customer" + i));
    }

}
