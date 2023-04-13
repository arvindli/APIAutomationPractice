package com.api.pojo;

import java.util.List;

public class PojoClass {
	
	private static String name;
	public static String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	private String job;
	private static List<String> jobs;
	public List<String> getJobs() {
		return jobs;
	}
	public void setJobs(List<String> jobs) {
		this.jobs = jobs;
	}
	
	private List<Cars> carss;
	public List<Cars> getCarss() {
		return carss;
	}
	public void setCarss(List<Cars> carss) {
		this.carss = carss;
	}
	
	

}
