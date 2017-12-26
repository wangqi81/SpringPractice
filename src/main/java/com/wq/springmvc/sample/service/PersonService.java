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
		return personMapper.selectPerson(id);
	}

	public int insertPerson(Person person) {
		return personMapper.insertPerson(person);
	}
}
