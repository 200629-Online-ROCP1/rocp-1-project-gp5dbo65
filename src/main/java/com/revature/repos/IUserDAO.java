/* IUserDAO.java */

package com.revature.repos;

import java.util.List;

import com.revature.models.User;

public interface IUserDAO {
	
	public List<User> findAll();
	public User findById(int id);
	public User findByUserName(String username);
	public User findByLastName(String lastname);
	public boolean register(User u);
	public boolean updateUser(User user);
	public boolean validUserRole(User user);

} //end of IUserDAO interface
