/**
 * 
 */
package com.ashu.sbt.bt.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ashu.sbt.bt.ent.Employee;

/**
 * @author Ashok Kumar Jha
 *
 */

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

	public Employee findEmployeeByFirstName(String name);

	public List<Employee> findAll();

	public Employee findEmployeeByEmployeeId(String id);

	public void deleteEmployeeByEmployeeId(String empId);
}