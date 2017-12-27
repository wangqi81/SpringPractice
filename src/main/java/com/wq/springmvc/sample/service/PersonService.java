package com.wq.springmvc.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wq.springmvc.sample.dao.PersonMapper;
import com.wq.springmvc.sample.entity.Person;

@Component
public class PersonService {
	
	@Autowired
	private PersonMapper personMapper;

	public List<Person> selectAllPerson() {
		return personMapper.selectAllPerson();
	}

	public Person selectPerson(int id) {
		Person person = personMapper.selectPerson(id);
		
		personMapper.insertPerson(person);
		
		return person;
	}

	public int insertPerson(Person person) {
		return personMapper.insertPerson(person);
	}
}
