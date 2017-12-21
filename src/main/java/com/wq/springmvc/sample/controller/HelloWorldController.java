package com.wq.springmvc.sample.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wq.springmvc.sample.entity.Message;

@RestController
@RequestMapping("/")
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello() {

		return "welcome";
	}

	@RequestMapping("/hello/{player}")
	public Message message(@PathVariable String player) {// REST Endpoint.

		Message msg = new Message(player, "Hello " + player);
		
		return msg;
	}
}
