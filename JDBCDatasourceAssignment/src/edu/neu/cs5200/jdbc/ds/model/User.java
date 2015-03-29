package edu.neu.cs5200.jdbc.ds.model;

import java.sql.Date;

public class User {
	private int id;
	private String username;
	private String password;
	private String lastname;
	private String firstname;
	private String email;
	private Date dateofbrith;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateofbrith() {
		return dateofbrith;
	}
	public void setDateofbrith(Date dateofbrith) {
		this.dateofbrith = dateofbrith;
		System.out.println(this.dateofbrith);
	}
	public User(int id, String username, String password, String lastname,
			String firstname, String email, Date dateofbrith) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.dateofbrith = dateofbrith;
	System.out.println(this.dateofbrith);
	}
	public User() {
		super();
	}
	
}




