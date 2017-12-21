package com.wq.springmvc.sample.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class EmployeeAspectJoinPoint {
	
	private final static Logger logger = LoggerFactory.getLogger(EmployeeAspectJoinPoint.class);

	@Before("execution(public void com.wq.springmvc.sample.entity..*.*(..))")
//	@Before("execution(public String getName())")
	public void loggingAdvice(JoinPoint joinPoint) {
		logger.info("Before running loggingAdvice on method=" + joinPoint.toString());

		logger.info("Agruments Passed=" + Arrays.toString(joinPoint.getArgs()));

	}

	// Advice arguments, will be applied to bean methods with single String argument
//	@Before("args(name)")
//	public void logStringArguments(String name) {
//		logger.info("String argument passed=" + name);
//	}

}