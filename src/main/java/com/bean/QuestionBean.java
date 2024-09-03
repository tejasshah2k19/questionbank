package com.bean;

 
public class QuestionBean {
	private int queId;
	private String question;
	private String explanation;
	private String example1;
	private String example2;
	private String subject;
	private String topic;
	private String difficulty;
	public int getQueId() {
		return queId;
	}
	public void setQueId(int queId) {
		this.queId = queId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getExample1() {
		return example1;
	}
	public void setExample1(String example1) {
		this.example1 = example1;
	}
	public String getExample2() {
		return example2;
	}
	public void setExample2(String example2) {
		this.example2 = example2;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
}