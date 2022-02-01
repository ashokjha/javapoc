/**
 * 
 */
package com.ashu.sbt.micro.service.order.service.srv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashu.sbt.micro.service.order.service.ent.Order;
import com.ashu.sbt.micro.service.order.service.rep.OrderRepository;

/**
 * @author Ashok Kumar Jha
 *
 */
@Service
public class OrderService {
	@Autowired
	private OrderRepository ordrep;

	public Order saveOrder(Order order) {
		return ordrep.save(order);
	}

	public List<Order> fetchAllOrder() {
		return ordrep.findAll();
	}
}
