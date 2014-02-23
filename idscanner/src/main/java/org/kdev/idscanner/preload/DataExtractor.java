package org.kdev.idscanner.preload;

import java.util.List;

import org.kdev.idscanner.domain.entity.Person;
import org.kdev.idscanner.injector.AppCoreModule;
import org.kdev.idscanner.injector.AppInitializer;
import org.kdev.idscanner.injector.AppPersistenceModule;
import org.kdev.idscanner.service.PersonService;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

public class DataExtractor {

	private static final String BASE_URL = "http://192.168.1.69:8080/idscanner/index.jsp?id=";

	public static void main(String[] args) {

		final Injector injector = Guice.createInjector(new JpaPersistModule("IDSCANNER-JPA"), new AppCoreModule(),
				new AppPersistenceModule());
		injector.getInstance(AppInitializer.class);
		final PersonService personService = injector.getInstance(PersonService.class);

		extract(personService.getAll());
	}

	private static void extract(final List<Person> persons) {
		for (final Person person : persons) {
			print(person);
		}
	}
	
	private static void print(final Person person) {
		System.out.println("---------------------------");
//		System.out.println("Country: " + person.getCountry());
//		System.out.println("Name: " + person.getName());
//		System.out.println("Surname: " + person.getSurname());
		System.out.println(BASE_URL + person.getCode());
	}
}
