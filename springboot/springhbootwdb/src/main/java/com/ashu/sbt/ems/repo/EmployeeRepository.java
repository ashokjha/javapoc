/**
 * 
 */
package com.ashu.sbt.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu.sbt.ems.model.Employee;

/**
 * Repository Class
 * Repository interfaces don’t need @Repository annotation as parent interface implementation already provides the same
 * @author Ashok Kumar Jha
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
