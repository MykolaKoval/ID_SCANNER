package org.kdev.idscanner.injector;

import org.kdev.idscanner.service.DefaultImageResource;
import org.kdev.idscanner.service.ImageResource;

import com.google.inject.AbstractModule;

public class AppCoreModule extends AbstractModule {

	@Override
	protected void configure() {

		bind(ImageResource.class).to(DefaultImageResource.class);
	}

}
