/* UserService.java */

package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.repos.IUserDAO;
import com.revature.repos.UserDAO;

public class UserService {
	
	private final IUserDAO  dao = new UserDAO();
	
	public List<User> findAll() {
		return dao.findAll();
	} //end findAll() method

	public User findById(int id) {
		return dao.findById(id);
	} //end findByUserId(id) method
	
	public User findByUserName(String username) {
		return dao.findByUserName(username);
	} //end findByUserName(username) method
	
	public boolean register(User u) {
		List<User> list = findAll();
		
		for(User ul: list) {
			if(ul.getUsername().equals(u.getUsername( )) 
					&& ul.getFirstName().equals(u.getFirstName()) 
					&& ul.getLastName().equals(u.getLastName())) {
				return false;
			} //end if block
		} //end for-each loop
		
		boolean b = dao.register(u);
		return b;
	} //end register(u) method
	
} //end UserService class
