package com.shahid.mercans.assignment2.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request class defined as per in-house API request structure
 * @author Shahid Farooq
 *
 */
public class Request {

	@JsonProperty("uuid")
	private String uuid;
	@JsonProperty("fname")
	private String fname;
	@JsonProperty("erros")
	List<String> erros;
	@JsonProperty("payLoad")
	private List<Person> persons;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
}
