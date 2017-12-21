package com.wq.springmvc.sample.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class EmployeeAnnotationAspect {
	
	private final static Logger logger = LoggerFactory.getLogger(EmployeeAnnotationAspect.class);
	
	@Before("@annotation(com.wq.springmvc.sample.aspect.Loggable)")
	public void myAdvice(){
		logger.info("Executing myAdvice!!");
	}
	
}
