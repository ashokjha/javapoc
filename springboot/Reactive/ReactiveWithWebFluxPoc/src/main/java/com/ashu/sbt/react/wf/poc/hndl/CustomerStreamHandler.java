/**
 * 
 */
package com.ashu.sbt.react.wf.poc.hndl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
public class CustomerStreamHandler {

    @Autowired
    private CustomerDao custDao;

    /**
     * 
     * @param req
     * @return Customer List as a full object . Problem blocking
     */
    public Mono<ServerResponse> getCustomers(ServerRequest req) {
        return ServerResponse.ok().body(custDao.getListOfCustomersStream(),
                Customer.class);

    }

    /**
     * 
     * @param req
     * @return One Customer as stream at a time
     */
    public Mono<ServerResponse> getCustomersSt(ServerRequest req) {
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(custDao.getListOfCustomersStream(), Customer.class);
    }

}
