package com.tcampest.curriculum.domain;

import org.springframework.data.annotation.Id;

public class User {

	@Id
	private String id;

	private String firstName;
	private String lastName;
	
	private String username;
	private String password;
	
	private String[] grantedAuthorities;

	public User() {
	}

	public User(String firstName, String lastName, String username, String password, String[] grantedAuthorities) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.grantedAuthorities = grantedAuthorities;
	}
	
	public String getLogin() {
		return username;
	}

	public void setLogin(String username) {
		this.username = username;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("User[id=%s, firstName='%s', lastName='%s']", id, firstName, lastName);
	}

	public String[] getGrantedAuthorities() {
		return grantedAuthorities;
	}

	public void setGrantedAuthorities(String[] grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}