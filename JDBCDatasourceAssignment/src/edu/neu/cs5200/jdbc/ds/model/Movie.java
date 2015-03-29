package edu.neu.cs5200.jdbc.ds.model;

import java.sql.Date;

public class Movie {
	private int id;
	private String title;
	private String posterImage;
	private Date relaseDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPosterImage() {
		return posterImage;
	}
	public void setPosterImage(String posterImage) {
		this.posterImage = posterImage;
	}
	public Movie() {
		super();
	}
	public Movie(int id, String title, String posterImage, Date relaseDate) {
		super();
		this.id = id;
		this.title = title;
		this.posterImage = posterImage;
		this.relaseDate = relaseDate;
	}
	public Date getRelaseDate() {
		return relaseDate;
	}
	public void setRelaseDate(Date relaseDate) {
		this.relaseDate = relaseDate;
	}
	
}
