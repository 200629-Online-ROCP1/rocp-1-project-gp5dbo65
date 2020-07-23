/* LoginDTO.java */

package com.revature.models;

public class LoginDTO {
	
	/* This DTO - Data Transfer Object is what will be used to capture the login information and look up the user in the database. */
	public String username;
	public String password;
	public String role;
	/* May want to change this DTO to store the user object returned from the DB after a successful login*/
	//public boolean isLogged;

	} //end LoginDTO class
