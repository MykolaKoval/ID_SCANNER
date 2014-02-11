package org.kdev.idscanner.domain.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.kdev.idscanner.domain.entity.Person;


public class PersonDaoTest extends BaseDaoTest<Person> {

	private static final String PERSON_CODE = "JHGJFVUIKTFD&ITYVJMVBMNBVJ<VCH";
	private static final String PERSON_IMG = "143235adJHGJFVasdfUI2352352KTFasdfD&ITYVkjabdfkJMVBMNBVJ<VC25422352H";
	@Test
	public void testInsertRecord() throws Exception {
		Person person = new Person();

		person.setName("Jeff");
		person.setSurname("King");
		person.setCountry("Canada");
		person.setDirector(false);
		person.setCode(PERSON_CODE);
		person.setImg(PERSON_IMG);
		Assert.assertNotNull(dao.insert(person));
	}

	@Test
	public void testDeleteRecord() throws Exception {
		Person person = new Person();

		Long id = dao.insert(person);
		person = dao.find(id);
		dao.delete(person);
	}

	@Test
	public void testSelect() throws Exception {
		Person person = new Person();

		person.setName("Jeff");
		person.setSurname("King");
		person.setCountry("Canada");
		person.setDirector(true);
		person.setCode(PERSON_CODE);
		person.setImg(PERSON_IMG);

		Long id = dao.insert(person);

		Person personFromDb = dao.find(id);
		Assert.assertNotNull(personFromDb);
		Assert.assertEquals("Jeff", personFromDb.getName());
		Assert.assertEquals("King", personFromDb.getSurname());
		Assert.assertEquals("Canada", personFromDb.getCountry());
		Assert.assertTrue(personFromDb.isDirector());
		Assert.assertEquals(PERSON_CODE, personFromDb.getCode());
		Assert.assertEquals(PERSON_IMG, personFromDb.getImg());
	}

	@Test
	public void testUpdate() throws Exception {
		Person person = new Person();
		person.setName("Jeff");

		Long id = dao.insert(person);

		Person personFromDB = dao.find(id);
		Assert.assertNotNull(personFromDB);
		Assert.assertEquals("Jeff", personFromDB.getName());

		personFromDB.setName("Joseph");
		dao.update(personFromDB);

		personFromDB = dao.find(id);
		Assert.assertNotNull(personFromDB);
		Assert.assertEquals("Joseph", personFromDB.getName());
	}

	@Test
	public void testGetAll() {
		Person person1 = new Person();
		Person person2 = new Person();
		Person person3 = new Person();

		dao.insert(person1);
		dao.insert(person2);
		dao.insert(person3);

		List<Person> allPersons = dao.findAll();
		Assert.assertEquals(3, allPersons.size());
	}
}
