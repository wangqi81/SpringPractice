package com.wq.springmvc.sample.service;

import com.wq.springmvc.sample.entity.Employee;

public class EmployeeService {
	private Employee employee;

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee e) {
		this.employee = e;
	}
}
