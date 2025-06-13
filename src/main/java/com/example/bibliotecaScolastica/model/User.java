package com.example.bibliotecaScolastica.model;

public class User {
	private String username;
	private String password;
	
	public User (String username, String password) {
		this.username=username;
		this.password=password;
	}
	
	//metodi get e set
	public String getUsername() {return username;}
	public void setUsername(String username) {
		this.username=username;
	}
	
	public String getPassword () {return password;}
	public void setPassword(String password) {
		this.password=password;
	}
}
