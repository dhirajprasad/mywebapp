package com.webapp.modal;

public class Result {

	private String name ;
	private String coursename;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return coursename;
	}
	public void setCourse(String course) {
		this.coursename = course;
	}
	@Override
	public String toString() {
		return "Result [name=" + name + ", coursename=" + coursename + "]";
	}
	
	
}
