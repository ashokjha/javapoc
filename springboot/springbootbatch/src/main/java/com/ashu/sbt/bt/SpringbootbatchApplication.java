package com.ashu.sbt.bt;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import com.ashu.sbt.bt.bean.EmployeeDetail;
import com.ashu.sbt.bt.ent.Employee;
import com.ashu.sbt.bt.srv.IEmployeeSrv;

/**
 * @author Ashok Kumar Jha
 *
 */
//@SpringBootApplication
@EnableMongoAuditing
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SpringbootbatchApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(SpringbootbatchApplication.class);

	@Autowired
	IEmployeeSrv empsrv;

	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootbatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Empty DB");
		empsrv.deleteAll();
		System.out.println("Populate Data from Input Data File data.csv");
		JobParameters jobParameters = new JobParametersBuilder().addLong("startAt", System.currentTimeMillis())
				.toJobParameters();
		try {
			jobLauncher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException exp) {

			log.error(exp.getMessage());
		}

		EmployeeDetail empd = new EmployeeDetail("999", "Sky Is", "Limit", "sil@imnf.prb");

		System.out.println("Save -> " + empsrv.save(empd));

		System.out.println("FindAll ->:");
		empsrv.findAll().forEach(emp -> System.out.println(emp));
		System.out.println("Find By FirstName ->: " + empsrv.findEmployeeByFirstName("Ram"));

		Employee emp = empsrv.findEmployeeByEmployeeId("04");
		System.out.println(emp);
		emp.setLastName("Saha");
		System.out.println("Update -> " + empsrv.update(emp));

		emp = empsrv.findEmployeeByEmployeeId("999"); 
		System.out.println("Remove Enployee with Employee ID 999 -> "+emp);
		
		empsrv.deleteEmployeeByEmployeeId("999");
		emp = empsrv.findEmployeeByEmployeeId("999"); 
		
		System.out.println("After Removal Employee with Employee ID 999-> "); 
		empsrv.findEmployeeByEmployeeId("999");

	}

}
