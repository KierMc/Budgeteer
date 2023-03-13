package com.kiernan.budgetapp.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {

	//Attributes: email, password
	@NotEmpty(message="Email is required!")
	@Email(message="Please enter valid email!")
	private String email;
	
	@NotEmpty(message="Password is required!")
	@Size(min=1, max=255, message="Password must be between 1 and 255 characters!")
	private String password;
	
	//constructor
	public LoginUser() {}
	
	//Getters and Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
