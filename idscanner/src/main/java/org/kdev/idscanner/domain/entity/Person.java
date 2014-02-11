package org.kdev.idscanner.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
@NamedQuery(name = "Person.GetAll", query = "SELECT p FROM Person p")
public class Person extends AbstractEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "code", length = 32)
	private String code;
	
	@Column(name = "name", length = 32)
	private String name;

	@Column(name = "surname", length = 32)
	private String surname;

	@Column(name = "country", length = 32)
	private String country;
	
	@Column(name = "is_director", columnDefinition = "BOOLEAN")
	private Boolean isDirector;
	
	@Lob
	@Column(name = "img_blob", length = 300000)
	private String imgBlob;

	public Person() {
	}

	public Person(Long id) {
		this.id = id;
	}

	public Person(final String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getImg() {
		return imgBlob;
	}

	public void setImg(final String imgBlob) {
		this.imgBlob = imgBlob;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Boolean isDirector() {
		return isDirector;
	}

	public void setDirector(Boolean isDirector) {
		this.isDirector = isDirector;
	}

}
