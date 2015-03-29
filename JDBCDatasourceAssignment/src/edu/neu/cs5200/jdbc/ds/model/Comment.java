package edu.neu.cs5200.jdbc.ds.model;

import java.sql.Date;

public class Comment {
	private int id;
	private String comment;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Comment(int id, String comment, Date date) {
		super();
		this.id = id;
		this.comment = comment;
		this.date = date;
	}
	public Comment() {
		super();
	}
	
}
