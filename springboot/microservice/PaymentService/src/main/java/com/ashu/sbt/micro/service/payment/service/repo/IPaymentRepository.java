/**
 * 
 */
package com.ashu.sbt.micro.service.payment.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashu.sbt.micro.service.payment.service.ent.Payment;

/**
 * @author Ashok Kumar Jha
 *
 */
@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

}
