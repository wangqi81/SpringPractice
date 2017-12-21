package com.wq.springmvc.sample.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class EmployeeAspect {

	private final static Logger logger = LoggerFactory.getLogger(EmployeeAspect.class);

	@Before("execution(public String getName())")
	public void getNameAdvice() {
		logger.info("Executing Advice on getName()");
	}

	@Before("execution(* com.wq.springmvc.sample.service.*.get*())")
	public void getAllAdvice() {
		logger.info("Service method getter called");
	}
}	