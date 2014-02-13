package org.kdev.idscanner.service;

@SuppressWarnings("serial")
public class PersonNotFoundException extends RuntimeException {

	public PersonNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
