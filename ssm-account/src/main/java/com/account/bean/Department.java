package com.account.bean;

import java.io.Serializable;
import java.util.List;

public class Department implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private List<Job> jobs;
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
	 * @return the jobs
	 */
	public List<Job> getJobs() {
		return jobs;
	}
	/**
	 * @param jobs the jobs to set
	 */
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
}
