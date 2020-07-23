/* LoginService.java */

package com.revature.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.LoginDTO;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repos.IRoleDAO;
import com.revature.repos.RoleDAO;
import com.revature.util.ConnectionUtil;

public class LoginService {
	
	private static final IRoleDAO rdao = new RoleDAO();

	public boolean login(LoginDTO l) {
		User u = new User();

		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM users WHERE username = '" + l.username + "'";  //Build SQL for select for username
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);  //Assign the ResultSet after the query

			if(result.next()) {
				u.setUserId(result.getInt("userid"));
				u.setUsername(result.getString("username"));
				u.setPassword(result.getString("password"));
				u.setFirstName(result.getString("firstname"));
				u.setLastName(result.getString("lastname"));
				u.setEmail(result.getString("email"));
				Role r = rdao.findById(result.getInt("role")); //Build a Role object to get the String value of the Role from the DB
				u.setRole(r);
			} //end if block
		} //end try block
		
		catch(SQLException e) {
			e.printStackTrace();
			return false;  //Login process failed, send back a false value
		} //end catch block
		
		if(l.username.equals(u.getUsername()) && l.password.equals(u.getPassword())) {	//Check to see if the username & password matches to the User table
			Role tempRole = u.getRole();  //Store Role object into temporary Role object			
			l.role = tempRole.getRole();		//Get the string value of Role and store it in the LoginDTO
			return true;  //Login process passed, send back a true value
		} //end if block

		return false;  //Login process failed, send back a false value
	} //end login method
} //end LoginService() class
