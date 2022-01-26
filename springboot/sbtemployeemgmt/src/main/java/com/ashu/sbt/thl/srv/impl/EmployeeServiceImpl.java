/**
 * 
 */
package com.ashu.sbt.thl.srv.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashu.sbt.thl.exp.ResourceNotFoundException;
import com.ashu.sbt.thl.mdl.Employee;
import com.ashu.sbt.thl.repo.EmployeeRepo;
import com.ashu.sbt.thl.srv.IEmployeeService;

/**
 * @author Ashok Kumar Jha
 *
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepo emplrepo;

	@Override
	public List<Employee> getAllEmployees() {
		return emplrepo.findAll();
	}

	@Override
	public void saveEmployee(Employee empl) {
		emplrepo.save(empl);
	}

	@Override
	public Employee getEmployeeById(long id) {
		return emplrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
	}

	@Override
	public Employee updateEmployee(Employee empl, long id) {
		Employee curEmp = emplrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		BeanUtils.copyProperties(empl, curEmp);
		emplrepo.save(curEmp);
		return curEmp;
	}

	@Override
	public void removeEmployee(long id) {
		emplrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		emplrepo.deleteById(id);
	}

}
