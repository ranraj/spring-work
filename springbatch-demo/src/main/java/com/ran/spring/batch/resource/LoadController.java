package com.ran.spring.batch.resource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/load")
public class LoadController {
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	@GetMapping
	public BatchStatus load() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		Map<String, JobParameter> map = new HashMap<String, JobParameter>();
		map.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters jobParameters = new JobParameters(map);
		JobExecution jobExec = jobLauncher.run(job, jobParameters );
		while(jobExec.isRunning()) {
			System.out.println("System is running..");
		}
		return jobExec.getStatus();
	}
	public void stop() {
		
	}
}
