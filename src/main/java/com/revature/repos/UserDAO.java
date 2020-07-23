package com.revature.repos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDAO implements IUserDAO {
	
	private static final IRoleDAO rdao = new RoleDAO();

	@Override
	public List<User> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
				String sql = "SELECT * FROM  users;";
				Statement statement = conn.createStatement();
				List <User> list = new ArrayList<>();
				ResultSet result = statement.executeQuery(sql);
				
				while(result.next()) {
					User u = new User();
					u.setUserId(result.getInt("userid"));
					u.setUsername(result.getString("username"));
					u.setPassword(result.getString("password"));
					u.setFirstName(result.getString("firstname"));
					u.setLastName(result.getString("lastname"));
					u.setEmail(result.getString("email"));
					
					Role r = rdao.findById(result.getInt("roleid"));
					u.setRole(r);
					
					list.add(u);
				} //end while loop
				
				return list;
		} //end try block
		
		catch (SQLException e) {
			e.printStackTrace();
		} //end catch block
		
		return null;
	} //end findAll method

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByLastName(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validUserRole(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean register(User u) {
		// TODO Auto-generated method stub
		return false;
	}
	
} //end UserDAO interface
