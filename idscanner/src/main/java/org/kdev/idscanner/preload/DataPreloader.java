package org.kdev.idscanner.preload;

import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.jsefa.common.lowlevel.filter.HeaderAndFooterFilter;
import org.jsefa.csv.CsvDeserializer;
import org.jsefa.csv.CsvIOFactory;
import org.jsefa.csv.config.CsvConfiguration;
import org.kdev.idscanner.domain.entity.Person;
import org.kdev.idscanner.injector.AppCoreModule;
import org.kdev.idscanner.injector.AppInitializer;
import org.kdev.idscanner.injector.AppPersistenceModule;
import org.kdev.idscanner.service.PersonService;
import org.kdev.idscanner.util.ImageDecoder;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

public class DataPreloader {

	private static final String IMG_DIR = "/home/NA/PHOTOS";
	private final List<String> codes = Lists.newArrayList();
	
	public static void main(String[] args) {
		final List<RawPerson> persons = new DataPreloader().preload();

		final Injector injector = Guice.createInjector(new JpaPersistModule("IDSCANNER-JPA"), new AppCoreModule(),
				new AppPersistenceModule());
		injector.getInstance(AppInitializer.class);
		final PersonService personService = injector.getInstance(PersonService.class);

		for (final RawPerson rawPerson : persons) {
			personService.add(convert(rawPerson));
		}
	}

	private static Person convert(final RawPerson raw) {
		final Person person = new Person();
		person.setCode(trim(raw.getCode()));
		person.setName(trim(raw.getName()));
		person.setSurname(trim(raw.getSurname()));
		person.setCountry(trim(raw.getCountry()));
		person.setDirector("1".equals(raw.getDirector()));
		person.setImg(loadImg(raw.getImgName()));
		return person;
	}

	private static String trim(final String promt) {
		return promt != null ? promt.trim() : null;
	}

	private static String loadImg(final String imgName) {
		final File file = new File(IMG_DIR + "/" + imgName);
		if (file.exists()) {
			return ImageDecoder.encodeImage(file);
		}
		System.out.println(String.format("ERROR. Image file %s do not exist!!!", imgName));
		return null;
	}

	public List<RawPerson> preload() {
		final CsvConfiguration config = new CsvConfiguration();
		config.setFieldDelimiter(',');
		// header of size 1, no footer, store the filtered lines
		config.setLineFilter(new HeaderAndFooterFilter(1, false, true));
		final CsvDeserializer deserializer = CsvIOFactory.createFactory(config, RawPerson.class).createDeserializer();
		deserializer.open(createFileReader());

		final List<RawPerson> result = Lists.newArrayList();
		while (deserializer.hasNext()) {
			final RawPerson person = deserializer.next();
			//person.setCode(generateCode());
			result.add(person);
			print(person);
		}
		deserializer.close(true);
		return result;
	}

	private String generateCode() {
		String code = null;
		do {
			code = RandomStringUtils.randomAlphanumeric(15).toUpperCase();
		} while (codes.contains(code));
		codes.add(code);
		return code;
	}

	private void print(final RawPerson person) {
		System.out.println("---------------------------");
		System.out.println("Country: " + person.getCountry());
		System.out.println("Code: " + person.getCode());
		System.out.println("Name: " + person.getName());
		System.out.println("Surname: " + person.getSurname());
		System.out.println("Director: " + person.getDirector());
		System.out.println("Image: " + person.getImgName());
		System.out.println("Code: " + person.getCode());
	}

	private Reader createFileReader() {
		return new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("persons.csv"));
	}
}
