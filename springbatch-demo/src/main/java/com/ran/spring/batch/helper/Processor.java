package com.ran.spring.batch.helper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.ran.spring.batch.model.User;

@Component
public class Processor implements ItemProcessor<User, User> {
	
	private static final Map<String,String> DEPT_NAMES = new HashMap<>();
	static{
		DEPT_NAMES.put("001", "Dev");
		DEPT_NAMES.put("002", "Ops");
		DEPT_NAMES.put("003", "QA");
	}
	@Override
	public User process(User user) throws Exception {
		
		String deptCode = user.getDept();
		user.setDept(DEPT_NAMES.get(deptCode));
        user.setTime(new Date());
		return user;
	}

}
