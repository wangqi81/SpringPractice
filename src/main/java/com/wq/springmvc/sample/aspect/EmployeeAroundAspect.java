package com.wq.springmvc.sample.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class EmployeeAroundAspect {

	private final static Logger logger = LoggerFactory.getLogger(EmployeeAroundAspect.class);
	
//	@Around("execution(public String getName())")
//	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//		
//		logger.info("Before invoking getName() method");
//		
//		Object value = null;
//		
////		try {
//			value = proceedingJoinPoint.proceed();
////		} catch (Throwable e) {
////			e.printStackTrace();
////		}
//		
//		logger.info("After invoking getName() method. Return value=" + value);
//		
//		return value;
//	}
	
	@Around("execution(* com.wq.springmvc.sample.service..*.*(..)) or execution(* com.wq.springmvc.sample.controller..*.*(..))")
	public Object employeeServiceAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		logger.info("Before invoking {} method", proceedingJoinPoint.getSignature());
		
		Object value = null;
		
		value = proceedingJoinPoint.proceed();
		
		logger.info("After invoking {} method. Return value=" + value, proceedingJoinPoint.getSignature());
		
		return value;
	}
	
}