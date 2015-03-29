package edu.neu.cs5200.jdbc.ds.model;

import java.sql.Date;

public class Actor {
	private int id;
	private String firstname;
	private String lastname;
	private Date dateofbrith;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDateofbrith() {
		return dateofbrith;
	}
	public void setDateofbrith(Date dateofbrith) {
		this.dateofbrith = dateofbrith;
	}
	public Actor(int id, String firstname, String lastname, Date dateofbrith) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateofbrith = dateofbrith;
	}
	public Actor() {
		super();
	}
	
}
