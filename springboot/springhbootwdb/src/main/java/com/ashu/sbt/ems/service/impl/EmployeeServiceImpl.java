/**
 * 
 */
package com.ashu.sbt.ems.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ashu.sbt.ems.exp.ResourceNotFoundException;
import com.ashu.sbt.ems.model.Employee;
import com.ashu.sbt.ems.repo.EmployeeRepository;
import com.ashu.sbt.ems.service.IEmployeeService;

/**
 * @author Ashok Kumar Jha
 *
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	private EmployeeRepository emplrepo;

	/**
	 * @param emplrepo
	 */
	public EmployeeServiceImpl(EmployeeRepository emplrepo) {
		super();
		this.emplrepo = emplrepo;
	}

	@Override
	public Employee saveEmployee(Employee empl) {
		return emplrepo.save(empl);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return emplrepo.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		/*
		 * Optional<Employee> employee = emplrepo.findById(id); if
		 * (employee.isPresent()) { return employee.get(); } else { throw new
		 * ResourceNotFoundException("Employee", "id", id); }
		 */

		return emplrepo.findById(id).orElseThrow(() 
							-> new ResourceNotFoundException("Employee", "id", id));
	}

	@Override
	public Employee updateEmployee(Employee empl, long id) {
		Employee curEmp = emplrepo.findById(id).orElseThrow(()
						-> new ResourceNotFoundException("Employee", "id", id));
		BeanUtils.copyProperties(empl, curEmp);
		emplrepo.save(curEmp);
		return curEmp;
	}

	@Override
	public void removeEmployee(long id) {

		emplrepo.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Employee", "id", id));
		emplrepo.deleteById(id);
	}

}
