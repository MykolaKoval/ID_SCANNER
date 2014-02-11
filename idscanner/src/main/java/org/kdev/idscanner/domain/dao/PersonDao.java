package org.kdev.idscanner.domain.dao;

import javax.persistence.TypedQuery;

import org.kdev.idscanner.domain.entity.Person;


public class PersonDao extends GenericDaoImpl<Person, Long> {

	@Override
	public Class<Person> getEntityClass() {
		return Person.class;
	}

	public Person findPerson(final String code) {
		final TypedQuery<Person> query = getEntityManager().createQuery("SELECT p FROM Person p WHERE p.code = :code",
				Person.class);
		return query.setParameter("code", code).getSingleResult();
	}
	
}
