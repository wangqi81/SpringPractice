package com.wq.springmvc.sample.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class EmployeeAroundAspect {

	private final static Logger logger = LoggerFactory.getLogger(EmployeeAroundAspect.class);
	
	@Around("execution(public String getName())")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		
		logger.info("Before invoking getName() method");
		
		Object value = null;
		
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		logger.info("After invoking getName() method. Return value=" + value);
		
		return value;
	}
	
}