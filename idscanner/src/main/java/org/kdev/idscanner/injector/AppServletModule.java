package org.kdev.idscanner.injector;

import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;

public class AppServletModule extends ServletModule {

	@Override
	protected void configureServlets() {
		// PersistFilter provides a new instance of EntityManager for each
		// request to the servlet container (Open Session In View pattern)
		install(new JpaPersistModule("IDSCANNER-JPA"));
		filter("/*").through(PersistFilter.class);
	}

}
