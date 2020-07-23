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
			
			String sql = "SELECT * FROM users WHERE username = '" + l.username + "'";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			if(result.next()) {
				u.setUserId(result.getInt("userid"));
				u.setUsername(result.getString("username"));
				u.setPassword(result.getString("password"));
				u.setFirstName(result.getString("firstname"));
				u.setLastName(result.getString("lastname"));
				u.setEmail(result.getString("email"));
				System.out.println("User = " + u.getFirstName());
				System.out.println("roleid = " + result.getInt("role"));
				Role r = rdao.findById(result.getInt("role"));
				u.setRole(r);
				
				System.out.println("role = " + u.getRole().toString());
			} //end if block
			
		} //end try block
		
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		} //end catch block
		
		if(l.username.equals(u.getUsername()) && l.password.equals(u.getPassword())) {
			Role tempRole = u.getRole();
			
			l.role = tempRole.getRole();
			System.out.println("LoginService = true");
			return true;
		} //end if block

		System.out.println("LoginService = false");
		return false;
	} //end login method

} //end LoginService() class
