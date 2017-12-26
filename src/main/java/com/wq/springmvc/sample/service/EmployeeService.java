package com.wq.springmvc.sample.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wq.springmvc.sample.aspect.EmployeeAfterAspect;
import com.wq.springmvc.sample.entity.Employee;

@Component
public class EmployeeService {
	
	private final static Logger logger = LoggerFactory.getLogger(EmployeeAfterAspect.class);
	
	private Employee employee;

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee e) {
		this.employee = e;
	}
	
//	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		
//		logger.info("The time is now {}", dateFormat.format(new Date()));
    }
}
