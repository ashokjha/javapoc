/**
 * 
 */
package com.ashu.sbt.micro.service.order.service.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashu.sbt.micro.service.order.service.ent.Order;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
