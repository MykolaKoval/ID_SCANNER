package org.kdev.idscanner.service;

import org.kdev.idscanner.domain.entity.Person;

public interface PersonService {

	Person get(String code);
	
	void add(Person person);
}
