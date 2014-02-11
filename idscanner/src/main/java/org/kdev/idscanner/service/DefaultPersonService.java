package org.kdev.idscanner.service;

import java.io.File;

import javax.inject.Inject;

import org.kdev.idscanner.domain.dao.PersonDao;
import org.kdev.idscanner.domain.entity.Person;
import org.kdev.idscanner.util.ImageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultPersonService implements PersonService {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultPersonService.class);
	
	@Inject
	private PersonDao personDao;
	
	@Override
	public Person getPerson(final String code) {
		LOG.info("Requested person data for code: {}", code);
		final File file = new File("D:/projects/ID_SCANNER/idscanner/src/test/resources/test.png");
		Person person = personDao.findPerson(code);
		person.setDirector(false);
		person.setImg(ImageDecoder.encodeImage(file));
		return personDao.findPerson(code);
	}


}
