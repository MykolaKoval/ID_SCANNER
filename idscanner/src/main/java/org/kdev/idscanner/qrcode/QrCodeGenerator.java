package org.kdev.idscanner.qrcode;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.ws.rs.core.MultivaluedMap;

import org.kdev.idscanner.domain.entity.Person;
import org.kdev.idscanner.injector.AppCoreModule;
import org.kdev.idscanner.injector.AppInitializer;
import org.kdev.idscanner.injector.AppPersistenceModule;
import org.kdev.idscanner.service.PersonService;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class QrCodeGenerator {

	private static final String BASE_URL = "http://192.168.2.1:8080/idscanner/index.jsp?id=";
	private static final String IMAGES_DIR = "/home/NA/QR_CODES";
	
	private static WebResource resource;

	static {
		final Client c = Client.create();
		resource = c.resource("http://api.qrserver.com/v1/create-qr-code/");
	}

	public static void main(String[] args) throws IOException {
		
		final Injector injector = Guice.createInjector(new JpaPersistModule("IDSCANNER-JPA"), new AppCoreModule(),
				new AppPersistenceModule());
		injector.getInstance(AppInitializer.class);
		final PersonService personService = injector.getInstance(PersonService.class);
		
		generate(personService.getAll());
	}

	private static void generate(final List<Person> persons) {
		for (final Person person : persons) {
			generate(person);
		}
	}

	private static void generate(final Person person) {
		final String data = BASE_URL + person.getCode();
		final String imgName = person.getCountry() + "_" + person.getName() + " " + person.getSurname() + "_QR";
		generateQrCode(data, imgName);
	}

	private static void generateQrCode(final String data, final String imgName) {
		
		try {
			final MultivaluedMap<String, String> params = new MultivaluedMapImpl();
			params.add("data", data);
			params.add("size", "400x400");

			final ClientResponse response = resource.queryParams(params).get(ClientResponse.class);
			final BufferedInputStream in = new BufferedInputStream(response.getEntityInputStream());
			final BufferedImage bufImg = ImageIO.read(in);
			ImageIO.write(bufImg, "png", new File(IMAGES_DIR + "/" + imgName + ".png"));
		} catch (final IOException e) {
			System.out.println("ERROR. Can not generate QR code for image: " + imgName);
		}
	}

}
