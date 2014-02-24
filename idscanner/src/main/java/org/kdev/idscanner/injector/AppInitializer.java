package org.kdev.idscanner.injector;

import javax.inject.Inject;

import com.google.inject.persist.PersistService;

public class AppInitializer {

	@Inject
	public AppInitializer(final PersistService service) {
		service.start();
		// At this point JPA is started and ready.

		// other application initializations if necessary
	}
}
