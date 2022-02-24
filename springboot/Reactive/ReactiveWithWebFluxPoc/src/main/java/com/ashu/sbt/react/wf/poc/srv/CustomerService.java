/**
 * 
 */
package com.ashu.sbt.react.wf.poc.srv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashu.sbt.react.wf.poc.dao.CustomerDao;
import com.ashu.sbt.react.wf.poc.dto.Customer;

import reactor.core.publisher.Flux;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@Service
public class CustomerService {

    @Autowired
    CustomerDao custDao;

    /**
     * Traditional Approach delay added to show the concept of reactive
     * 
     * @return List of Customers
     */
    public List<Customer> getAllCostomers() {
        long st = System.currentTimeMillis();
        List<Customer> liCusts = custDao.getListOfCustomers();
        long et = System.currentTimeMillis();
        System.out.println(
                "Time Taken in getListOfCustomers = " + (et - st) + " ms");
        return liCusts;
    }

    /**
     * Reactive Approach
     * 
     * @return Flux of Customers
     */
    public Flux<Customer> getAllCostomersStream() {
        long st = System.currentTimeMillis();
        Flux<Customer> liCusts = custDao.getListOfCustomersStream();
        long et = System.currentTimeMillis();
        System.out.println("Time Taken in getListOfCustomersStream = "
                + (et - st) + " ms");
        return liCusts;
    }

}
