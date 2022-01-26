/**
 * 
 */
package com.ashu.sbt.thl.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu.sbt.thl.mdl.Employee;

/**
 * @author Ashok Kumar Jha
 *
 */
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
