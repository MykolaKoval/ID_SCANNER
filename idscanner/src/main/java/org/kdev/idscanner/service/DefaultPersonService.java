package org.kdev.idscanner.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import org.kdev.idscanner.domain.dao.PersonDao;
import org.kdev.idscanner.domain.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultPersonService implements PersonService {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultPersonService.class);

	@Inject
	private PersonDao personDao;

	@Override
	public Person get(final String code) {
		LOG.info("Requested person data for code: {}", code);
		try {
			return personDao.findPerson(code);
		} catch (NoResultException e) {
			throw new PersonNotFoundException(String.format("Could not find person with code %s", code), e);
		}
	}

	@Override
	public List<Person> getAll() {
		return personDao.findAll();
	}
	
	@Override
	public void add(final Person person) {
		personDao.insert(person);
	}

}
