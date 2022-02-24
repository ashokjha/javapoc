/**
 * 
 */
package com.ashu.sbt.react.wf.poc.rout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.ashu.sbt.react.wf.poc.hndl.CustomerHandler;
import com.ashu.sbt.react.wf.poc.hndl.CustomerStreamHandler;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@Configuration
public class RouterConfig {
    @Autowired
    private CustomerHandler custHandle;

    @Autowired
    private CustomerStreamHandler custStmHandle;

    /**
     * Currently hardcoded done. However will check configuration...
     * 
     * @return ServerResponse Based on Routing
     */
    @Bean
    public RouterFunction<ServerResponse> route() {
        return RouterFunctions.route()
                .GET("/ashu/rout/customers", custHandle::loadCustomers)
                .GET("/ashu/rout/customers/stm", custStmHandle::getCustomers)
                .GET("/ashu/rout/customers/stma", custStmHandle::getCustomersSt)
                .GET("/ashu/rout/customers/{id}", custHandle::getCustomerbyId)
                .POST("/ashu/rout/customers/save", custHandle::saveCustomer)
                .build();
    }
}
