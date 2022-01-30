package com.ashu.sbt.bt.srv.iml;

import java.time.LocalDateTime;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.ashu.sbt.bt.bean.EmployeeDetail;
import com.ashu.sbt.bt.ent.Employee;

/**
 * @author Ashok Kumar Jha
 *
 */
@Service
public class EmployeeItemProcessor implements ItemProcessor<EmployeeDetail, Employee> {
//	private static final Logger log = LoggerFactory.getLogger(EmployeeItemProcessor.class);

	@Override
	public Employee process(EmployeeDetail item) throws Exception {
		Employee transformedEmployee = new Employee();
		transformedEmployee.setEmail(item.getEmail());
		transformedEmployee.setFirstName(item.getFirstName());
		transformedEmployee.setLastName(item.getLastName());
		transformedEmployee.setEmployeeId(item.getEmployeeId());
		transformedEmployee.setCreatedDate(LocalDateTime.now());
		transformedEmployee.setLastModifieDate(LocalDateTime.now());
		
		return transformedEmployee;
	}
}
