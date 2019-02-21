package com.ran.spring.batch.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.ran.spring.batch.model.User;
import com.ran.spring.batch.model.UserSync;
import com.ran.spring.batch.repository.UserSyncRepository;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

	@Autowired
	UserSyncRepository userSyncRepository;

	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, RepositoryItemReader<UserSync> reader,
			ItemProcessor<UserSync, User> processor, ItemWriter<User> writer) {
		Step step = stepBuilderFactory.get("syncDeptStep").<UserSync, User> chunk(100).reader(reader).processor(processor)
				.writer(writer).build();
		Job job = jobBuilderFactory.get("syncJob").incrementer(new RunIdIncrementer()).start(step).build();
		return job;
	}

	@Bean
	public RepositoryItemReader<UserSync> reader() {

		Map<String, Sort.Direction> sortMap = new HashMap<>();
		sortMap.put("id", Direction.DESC);
		RepositoryItemReader<UserSync> userSyncReader = new RepositoryItemReader<>();
		userSyncReader.setRepository(userSyncRepository);
		userSyncReader.setMethodName("findSyncByStatus");

		List<String> arguments = new ArrayList<>();
		arguments.add("New");
		arguments.add("Failed");

		userSyncReader.setArguments(arguments);
		userSyncReader.setSort(sortMap);
		userSyncReader.setSaveState(false);
		return userSyncReader;
	}

}
