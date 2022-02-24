/**
 * 
 */
package com.ashu.sbt.react.wf.poc.cntl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.sbt.react.wf.poc.dto.Customer;
import com.ashu.sbt.react.wf.poc.srv.CustomerService;

import reactor.core.publisher.Flux;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@RestController
@RequestMapping("ashu/customers")
public class CuctomersCntl {

    @Autowired
    CustomerService custSrv;

    /**
     * Traditional Approach
     * 
     * @return List of Customers
     */
    @RequestMapping
    public List<Customer> getAllCustomers() {
        return custSrv.getAllCostomers();
    }

    /**
     * Traditional Approach
     * 
     * @return List of Customers
     */
    @RequestMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersStream() {
        return custSrv.getAllCostomersStream();
    }

    /**
     * Stream Approach However has no benefit as not added into stream
     * 
     * @return List of Customers
     */
    @RequestMapping(value = "/stream1")
    public Flux<Customer> getAllCustomersStream1() {
        return custSrv.getAllCostomersStream();
    }

}
