package com.wq.springmvc.sample;

import java.io.FileNotFoundException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import com.wq.springmvc.sample.entity.Employee;
import com.wq.springmvc.sample.entity.Person;
import com.wq.springmvc.sample.service.EmployeeService;
import com.wq.springmvc.sample.service.PersonService;

/**
 * Hello world!
 *
 */
public class App {

	private static Log log = LogFactory.getLog(App.class);

	public static void main(String[] args) throws FileNotFoundException {

		Log4jConfigurer.initLogging("classpath:log4j/log4j.xml");

//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-servlet.xml");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext((new String[]{"applicationContext.xml", "spring-servlet.xml"}));

		EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);

		employeeService.setEmployee(new Employee());

		employeeService.getEmployee().setName("testAOP Set Name");

		System.out.println(employeeService.getEmployee().getName());

		// employeeService.getEmployee().setName("Pankaj");

		// employeeService.getEmployee().throwException();

		PersonService service = (PersonService) ctx.getBean("personService");

		log.info("Running App...");

		System.out.println("List<Person> persons = service.selectAllPerson()");
		List<Person> persons = service.selectAllPerson();
		System.out.println("-> " + persons + "\n");

		System.out.println("Person person = service.selectPerson(2)");
		Person person = service.selectPerson(2);
		System.out.println("-> " + person + "\n");

		System.out.println("service.insertPerson(person)");
		person.setName("Inserted person");
		service.insertPerson(person);
		System.out.println("-> inserted..." + "\n");

		System.out.println("List<Person> persons = service.selectAllPerson()");
		persons = service.selectAllPerson();
		System.out.println("-> " + persons + "\n");

		ctx.close();
	}
}
