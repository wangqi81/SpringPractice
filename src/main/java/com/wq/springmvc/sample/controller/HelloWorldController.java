package com.wq.springmvc.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wq.springmvc.sample.entity.Message;
import com.wq.springmvc.sample.entity.Person;
import com.wq.springmvc.sample.service.EmployeeService;
import com.wq.springmvc.sample.service.PersonService;

@RestController
@RequestMapping("/")
public class HelloWorldController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private PersonService personService;

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello() {

		return "welcome";
	}

	@RequestMapping("/hello/{player}")
	public Message hello(@PathVariable String player) {// REST Endpoint.

//		employeeService.setEmployee(new Employee());
//
//		employeeService.getEmployee().setName("testAOP Set Name");
		Person person = personService.selectPerson(2);
		
		Message msg = new Message(player, "Hello " + player);
		
		return msg;
	}
}
