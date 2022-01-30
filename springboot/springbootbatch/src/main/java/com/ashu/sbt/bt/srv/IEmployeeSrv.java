/**
 * 
 */
package com.ashu.sbt.bt.srv;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ashu.sbt.bt.bean.EmployeeDetail;
import com.ashu.sbt.bt.ent.Employee;

/**
 * @author USER
 *
 */
@Service
public interface IEmployeeSrv {

	void deleteAll();

	List<Employee> findAll();

	Employee findEmployeeByFirstName(String string);

	Employee update(Employee emp);

	Employee findEmployeeByEmployeeId(String string);

	Employee save(EmployeeDetail empd) throws Exception;

	void deleteEmployeeByEmployeeId(String empId);

}
