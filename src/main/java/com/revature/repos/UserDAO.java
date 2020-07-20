package com.revature.repos;

import com.revature.models.User;

public interface UserDAO {

	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public boolean hasAccess(User user); //verify the user has access to account
	public boolean insert(User user);
	public boolean insertStatement(User user); //add user
	public boolean isValid(User user); //verify the user credentials are valid
	public boolean updateUser(User user);
	public User findByFirstName(String firstName);
	public User findByUserName(String userName);
	public void findUserAccount(User user); //return account object or account #
	
	
} //end UserDAO interface
