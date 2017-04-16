package com.account.bean;

import java.util.List;

public class Enterprise {
	
	private List<Department> departments;
	private String name;
	/**
	 * @return the departments
	 */
	public List<Department> getDepartments() {
		return departments;
	}
	/**
	 * @param departments the departments to set
	 */
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
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
}
