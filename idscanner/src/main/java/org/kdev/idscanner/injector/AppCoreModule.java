package org.kdev.idscanner.injector;

import org.kdev.idscanner.service.DefaultPersonService;
import org.kdev.idscanner.service.PersonService;

import com.google.inject.AbstractModule;

public class AppCoreModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(PersonService.class).to(DefaultPersonService.class);
	}

}
