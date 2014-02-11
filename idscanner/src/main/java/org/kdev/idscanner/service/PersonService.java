package org.kdev.idscanner.service;

import org.kdev.idscanner.domain.entity.Person;

public interface PersonService {

	Person getPerson(String code);
}
