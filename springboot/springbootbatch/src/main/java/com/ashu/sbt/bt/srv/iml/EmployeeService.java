/**
 * 
 */
package com.ashu.sbt.bt.srv.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashu.sbt.bt.bean.EmployeeDetail;
import com.ashu.sbt.bt.ent.Employee;
import com.ashu.sbt.bt.repo.EmployeeRepository;
import com.ashu.sbt.bt.srv.IEmployeeSrv;

/**
 * @author ASshok Kumar Jha
 *
 */
@Service
public class EmployeeService implements IEmployeeSrv {

	@Autowired
	private EmployeeRepository repository;

	private EmployeeItemProcessor eip = new EmployeeItemProcessor();

	@Override
	public void deleteAll() {
		repository.deleteAll();

	}

	@Override
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	public Employee findEmployeeByFirstName(String name) {
		return repository.findEmployeeByFirstName(name);
	}

	@Override
	public Employee update(Employee emp) {
		return repository.save(emp);

	}

	@Override
	public Employee findEmployeeByEmployeeId(String id) {
		return repository.findEmployeeByEmployeeId(id);
	}

	@Override
	public Employee save(EmployeeDetail empd) throws Exception {
		Employee emp = eip.process(empd);
		return repository.save(emp);
	}

	@Override
	public void deleteEmployeeByEmployeeId(String empId) {
		repository.deleteEmployeeByEmployeeId(empId);
	}
}
