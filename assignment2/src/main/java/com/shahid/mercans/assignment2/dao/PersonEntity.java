package com.shahid.mercans.assignment2.dao;

import java.util.Map;

import com.shahid.mercans.assignment2.models.Person;

public class PersonEntity {

	private int id;
	private String employeeCode;
	private String fullName;
	private String gender;
	private String birthDate;
	private String hireDate;
	private String terminationDate;
	
	public PersonEntity(){
	}
	
	public PersonEntity(Person person) {
		Map<String, String> map = person.getData();
		this.employeeCode = person.getEmployeeCode();
		if(map != null){
			if(map.containsKey("person.full_name"))
				this.fullName = map.get("person.full_name");
			if(map.containsKey("person.gender"))
				this.gender = map.get("person.gender");
			if(map.containsKey("person.birthdate"))
				this.birthDate = map.get("person.birthdate");
			if(map.containsKey("person.hire_date"))
				this.hireDate = map.get("person.hire_date");
			if(map.containsKey("person.termination_date"))
				this.terminationDate = map.get("person.termination_date");
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getTerminationDate() {
		return terminationDate;
	}
	public void setTerminationDate(String terminationDate) {
		this.terminationDate = terminationDate;
	}
}
