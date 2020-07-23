/* UserController.java */

package com.revature.controllers;

import java.util.List;

import com.revature.models.User;
import com.revature.services.UserService;

public class UserController {
	
	private final UserService us = new UserService();
	
	public List<User> findAll() {
		//System.out.println("UserControl: List findAll() method");
		return us.findAll();
	} //end findAll() method

	public User findById(int id) {
		//System.out.println("UserControl: findById() method");
		return us.findById(id);
	} //end findById(id) method
} //end UserController class
