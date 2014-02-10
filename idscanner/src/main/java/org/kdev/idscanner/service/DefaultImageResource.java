package org.kdev.idscanner.service;

import java.io.File;

import org.kdev.idscanner.util.ImageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultImageResource implements ImageResource {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultImageResource.class);

	@Override
	public String getImage(final String imgId) {
		LOG.info("Requested image for id: {}", imgId);
		final File file = new File("/home/projects/ID_SCANNER/idscanner/src/test/resources/test.png");
		return ImageDecoder.encodeImage(file);
	}

}
