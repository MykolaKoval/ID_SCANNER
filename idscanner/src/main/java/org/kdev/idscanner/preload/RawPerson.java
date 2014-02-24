package org.kdev.idscanner.preload;

import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;

@CsvDataType
public class RawPerson {

	@CsvField(pos = 1)
    private String country;
	
	@CsvField(pos = 2)
    private String name;
	
	@CsvField(pos = 3)
    private String surname;
	
	@CsvField(pos = 4)
    private String director;

	@CsvField(pos = 5)
    private String imgName;
	
	@CsvField(pos = 6)
	private String code;
	
	public String getCountry() {
		return country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(final String director) {
		this.director = director;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(final String imgName) {
		this.imgName = imgName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(final String code) {
		this.code = code;
	}
	
}
