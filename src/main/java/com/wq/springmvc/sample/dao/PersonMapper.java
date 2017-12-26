package com.wq.springmvc.sample.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.wq.springmvc.sample.entity.Person;

public interface PersonMapper {
	/******************************************
	 * Retrieves the List of person
	 * 
	 * @return person list
	 */
	// SQL query in xml "Mapper.xml"
	public List<Person> selectAllPerson();

	/******************************************
	 * Retrieves a person
	 * 
	 * @param person
	 *            id
	 * @return person
	 */
	// SQL query using annotation
	@Select("SELECT * FROM person")
	public List<Person> selectAllPerson2();

	/******************************************
	 * Retrieves a person
	 * 
	 * @param person
	 *            id
	 * @return person
	 */
	// SQL query using annotation
	@Select("SELECT * FROM person WHERE id = #{id}")
	public Person selectPerson(@Param("id") int id);

	/******************************************
	 * Insert a person
	 * 
	 * @param person
	 * @return int
	 */
	@Insert("INSERT INTO person (name) VALUES (#{name})")
	public int insertPerson(Person person);
}
