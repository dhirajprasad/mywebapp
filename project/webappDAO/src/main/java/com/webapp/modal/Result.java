package com.webapp.modal;

public class Result {

	private Integer aid;
	private String question;
	private String answer;
	
	
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
	
	public Result(Integer aid, String question, String answer) {
		super();
		this.aid = aid;
		this.question = question;
		this.answer = answer;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Result [name=" + name + ", coursename=" + coursename + "]";
	}
	
	
}
