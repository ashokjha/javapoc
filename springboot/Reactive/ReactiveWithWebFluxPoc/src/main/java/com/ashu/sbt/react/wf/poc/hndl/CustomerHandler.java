/**
 * 
 */
package com.ashu.sbt.react.wf.poc.hndl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.ashu.sbt.react.wf.poc.dao.CustomerDao;
import com.ashu.sbt.react.wf.poc.dto.Customer;

import reactor.core.publisher.Mono;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@Service
public class CustomerHandler {

    @Autowired
    private CustomerDao custDao;

    public Mono<ServerResponse> loadCustomers(ServerRequest req) {
        return ServerResponse.ok().body(custDao.getListOfCustomersForHandler(),
                Customer.class);
    }

    /**
     * 
     * @param req
     * @return One Customer as stream at a time
     */
    public Mono<ServerResponse> getCustomerbyId(ServerRequest req) {
        int custId = Integer.valueOf(req.pathVariable("id"));
        // Mono<Customer> cst = custDao.getFluxofCustomers()
        // .filter(cust -> cust.getId() == custId).take(1).single();

        Mono<Customer> cst = custDao.getFluxofCustomers()
                .filter(cust -> cust.getId() == custId).next();
        return ServerResponse.ok().body(cst, Customer.class);
    }

    /**
     * 
     * Save Customer For printing only for concept
     * 
     * @param req
     * @return One Customer as stream at a time
     */
    public Mono<ServerResponse> saveCustomer(ServerRequest req) {
        Mono<Customer> cstMono = req.bodyToMono(Customer.class);
        Mono<String> cstStr = cstMono
                .map(dto -> dto.getId() + ":" + dto.getName());
        return ServerResponse.ok().body(cstStr, String.class);
    }

}
