package com.leonardo.model;

import java.io.Serializable;

public class InformationMedia implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;
	private String author;
	private String information;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	

}
