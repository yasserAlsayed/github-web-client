package com.webb.githubweb.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Commit implements Serializable {
	private static final long serialVersionUID = 9110242215071262350L;
	private  String message;
	private Author author;
	
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public String getAuthorName() {
		return author.getName();
	}

	public String getCommitDate() {
		return new SimpleDateFormat("dd-mm-yyyy").format(author.getDate());
	}
}
