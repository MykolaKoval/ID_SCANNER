package org.kdev.idscanner.domain.dao;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

public class TestJPAInitializer {

	@Inject
	public TestJPAInitializer(final PersistService service) {
		service.start();
	}
}
