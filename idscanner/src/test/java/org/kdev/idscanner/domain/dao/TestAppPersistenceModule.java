package org.kdev.idscanner.domain.dao;

import org.kdev.idscanner.injector.AppPersistenceModule;

import com.google.inject.persist.jpa.JpaPersistModule;

public class TestAppPersistenceModule extends AppPersistenceModule {

	@Override
	protected void configure() {
		install(new JpaPersistModule("TEST-IDSCANNER-JPA"));
		bind(TestJPAInitializer.class).asEagerSingleton();
		super.configure();
	}

}
