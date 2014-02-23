package org.kdev.idscanner.service;

import java.util.List;

import org.kdev.idscanner.domain.entity.Person;

public interface PersonService {

	Person get(String code);
	
	List<Person> getAll(); 
	
	void add(Person person);
}
