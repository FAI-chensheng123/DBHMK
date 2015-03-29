package edu.neu.cs5200.jdbc.ds.model;

public class Cast {
	private int id;
	private String characterName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public Cast(int id, String characterName) {
		super();
		this.id = id;
		this.characterName = characterName;
	}
	public Cast() {
		super();
	}
	
	
}
