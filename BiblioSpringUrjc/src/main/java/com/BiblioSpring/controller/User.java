package com.BiblioSpring.controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private long id;
	private String Username;
	private long password;
	protected User() {}
	public User(String Username,long ISBN) {
		this.Username=Username;
		this.password=ISBN;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public long getPassword() {
		return password;
	}
	public void setPassword(long password) {
		this.password = password;
	}
	
}
