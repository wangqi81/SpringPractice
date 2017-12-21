package com.wq.springmvc.sample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class EmployeeAfterAspect {
	
	private final static Logger logger = LoggerFactory.getLogger(EmployeeAfterAspect.class);

	@After("args(name)")
	public void logStringArguments(String name) {
		logger.info("Running After Advice. String argument passed=" + name);
	}

	@AfterThrowing("within(com.wq.springmvc.sample.entity.Employee)")
	public void logExceptions(JoinPoint joinPoint) {
		logger.info("Exception thrown in Employee Method=" + joinPoint.toString());
	}

	@AfterReturning(pointcut = "execution(* getName())", returning = "returnString")
	public void getNameReturningAdvice(String returnString) {
		logger.info("getNameReturningAdvice executed. Returned String=" + returnString);
	}

}