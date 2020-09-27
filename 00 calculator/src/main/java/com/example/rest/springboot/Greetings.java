package com.example.rest.springboot;

public class Greetings {

	public long id;
	public String content;
	public Greetings(long l, String content) {
		this.id = l;
		this.content = content;
	}
	 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
