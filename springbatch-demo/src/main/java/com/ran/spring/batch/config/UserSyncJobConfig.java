package com.ran.spring.batch.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import com.ran.spring.batch.model.User;
import com.ran.spring.batch.model.UserSync;
import com.ran.spring.batch.repository.UserRepository;
import com.ran.spring.batch.repository.UserSyncRepository;

@Configuration
public class UserSyncJobConfig {
	
	@Autowired
	UserSyncRepository userSyncRepository;
	
	@Autowired
	UserRepository userRepository;
	
	private static final Map<Integer, String> DEPT_NAMES = new HashMap<>();
	
	static {
		DEPT_NAMES.put(001, "Dev");
		DEPT_NAMES.put(002, "Ops");
		DEPT_NAMES.put(003, "QA");
	}

	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<UserSync> reader, ItemProcessor<UserSync, User> processor, ItemWriter<User> writer) {
		Step step = stepBuilderFactory.get("syncDeptStep").<UserSync, User> chunk(100).reader(reader)
				.processor(processor).writer(writer).build();
		Job job = jobBuilderFactory.get("syncJob").incrementer(new RunIdIncrementer()).start(step).build();
		return job;
	}

	@Bean
	public RepositoryItemReader<UserSync> reader() {

		RepositoryItemReader<UserSync> reader = new RepositoryItemReader<>();
		reader.setRepository(userSyncRepository);
		reader.setMethodName("findSyncByStatus");
		reader.setPageSize(1000);
		
		List<String> arguments = new ArrayList<>();
		arguments.add("New");
		arguments.add("Failed");
		
		reader.setArguments(arguments);
		reader.setSort(Collections.singletonMap("id", Sort.Direction.ASC));
		reader.setSaveState(false);
		return reader;
	}
	
	@Bean
	public ItemProcessor<UserSync, User> processor(){
		return new ItemProcessor<UserSync, User>() {
			@Override
			public User process(UserSync userSync) throws Exception {
				Integer deptCode = userSync.getDept();
				User user = new User(userSync.getId(), userSync.getName(), DEPT_NAMES.get(deptCode), userSync.getSalary(),
						new Date());
				return user;
			}
		};
	}
	
	@Bean
	public RepositoryItemWriter<User> writter() {
		RepositoryItemWriter<User> userWritter = new RepositoryItemWriter<>();
		userWritter.setRepository(userRepository);
		userWritter.setMethodName("save");
		return userWritter;
	}
}
