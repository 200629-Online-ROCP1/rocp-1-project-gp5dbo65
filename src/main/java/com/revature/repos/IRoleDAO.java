/* IRoleDAO */

package com.revature.repos;

import java.util.List;

import com.revature.models.Role;

public interface IRoleDAO {

	public Role findById(int roleID);
	public Role findByRole(String role);
	List<Role> findAll();
	public boolean insertRole(Role r);
	
} //end IRoleDAO interface
