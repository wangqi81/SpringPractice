package com.wq.springmvc.sample;

import java.io.FileNotFoundException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import com.wq.springmvc.sample.service.EmployeeService;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws FileNotFoundException {
		
		Log4jConfigurer.initLogging("classpath:log4j/log4j.xml"); 
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-servlet.xml");

		EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);

		System.out.println(employeeService.getEmployee().getName());

		employeeService.getEmployee().setName("Pankaj");

//		employeeService.getEmployee().throwException();

		ctx.close();
	}
}
