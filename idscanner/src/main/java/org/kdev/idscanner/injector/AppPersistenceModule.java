package org.kdev.idscanner.injector;

import org.kdev.idscanner.domain.dao.GenericDao;
import org.kdev.idscanner.domain.dao.PersonDao;
import org.kdev.idscanner.domain.entity.Person;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public class AppPersistenceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(new TypeLiteral<GenericDao<Person, Long>>() {}).to(new TypeLiteral<PersonDao>() {});
	}

}
