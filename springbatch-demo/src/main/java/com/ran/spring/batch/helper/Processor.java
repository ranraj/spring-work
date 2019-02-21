package com.ran.spring.batch.helper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.ran.spring.batch.model.User;
import com.ran.spring.batch.model.UserSync;

@Component
public class Processor implements ItemProcessor<UserSync, User> {

	private static final Map<Integer, String> DEPT_NAMES = new HashMap<>();
	static {
		DEPT_NAMES.put(001, "Dev");
		DEPT_NAMES.put(002, "Ops");
		DEPT_NAMES.put(003, "QA");
	}

	@Override
	public User process(UserSync userSync) throws Exception {
		Integer deptCode = userSync.getDept();
		User user = new User(userSync.getId(), userSync.getName(), DEPT_NAMES.get(deptCode), userSync.getSalary(),
				new Date());
		return user;
	}

}
