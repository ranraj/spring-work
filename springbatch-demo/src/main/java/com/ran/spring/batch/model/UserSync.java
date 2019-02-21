package com.ran.spring.batch.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class UserSync {

	@Id
	private Integer id;
	private String name;
	private Integer dept;
	private Integer salary;
	private String status;

	public UserSync(Integer id, String name, Integer dept, Integer salary, String status) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.status = status;
	}

	public UserSync() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDept() {
		return dept;
	}

	public void setDept(Integer dept) {
		this.dept = dept;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserSync [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + ", status=" + status
				+ "]";
	}

}