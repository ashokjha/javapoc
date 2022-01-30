/**
 * 
 */
package com.ashu.sbt.bt.cfg;

import java.net.MalformedURLException;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileUrlResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.ashu.sbt.bt.bean.EmployeeDetail;
import com.ashu.sbt.bt.ent.Employee;
import com.ashu.sbt.bt.lst.JobCompletionNotificationListener;
import com.ashu.sbt.bt.srv.iml.EmployeeItemProcessor;

/**
 * @author Ashok Kumar Jha
 *
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public FlatFileItemReader<EmployeeDetail> reader() throws MalformedURLException {
		return new FlatFileItemReaderBuilder<EmployeeDetail>().name("userItemReader")
				.resource(new FileUrlResource("./data/data.csv")).delimited()
				.names(new String[] {"emloyeeId", "firstName", "lastName", "email" })
				.fieldSetMapper(new BeanWrapperFieldSetMapper<EmployeeDetail>() {
					{
						setTargetType(EmployeeDetail.class);
					}
				}).build();
	}

	@Bean
	public MongoItemWriter<Employee> writer(MongoTemplate mongoTemplate) {
		return new MongoItemWriterBuilder<Employee>().template(mongoTemplate)
				.collection("employee").build();
	}

	@Bean
	public EmployeeItemProcessor processor() {
		return new EmployeeItemProcessor();
	}

	@Bean
	public Step step1(FlatFileItemReader<EmployeeDetail> itemReader, MongoItemWriter<Employee> itemWriter)
			throws Exception {
		return this.stepBuilderFactory.get("step1").<EmployeeDetail, Employee>chunk(5).reader(itemReader)
				.processor(processor()).writer(itemWriter).build();
	}

	@Bean
	public Job updateUserJob(JobCompletionNotificationListener listener, Step step1) throws Exception {
		return this.jobBuilderFactory.get("updateUserJob").incrementer(new RunIdIncrementer()).listener(listener)
				.start(step1).build();
	}

}
