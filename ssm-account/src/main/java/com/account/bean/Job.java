package com.account.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Job implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private List<Person> persons = new ArrayList<>();
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the persons
	 */
	public List<Person> getPersons() {
		return persons;
	}
	/**
	 * @param persons the persons to set
	 */
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
}
