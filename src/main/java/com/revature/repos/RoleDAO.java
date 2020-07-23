/* RoleDAO.java */

package com.revature.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Role;
import com.revature.util.ConnectionUtil;

public class RoleDAO implements IRoleDAO {

	@Override
	public Role findById(int roleId) {
		System.out.println("in the findById method of RoleDAO class");
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM roles WHERE roleid = '" + roleId + "';";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				Role r = new Role();
				r.setRoleId(result.getInt("roleid"));
				r.setRole(result.getString("role"));
				return r;
			} //end if block
			
		} //end try block
		
		catch (SQLException e) {
			e.printStackTrace();
		} //end catch block
		
		return null;
	} //end findById(roleId) method

	@Override
	public Role findByRole(String role) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM roles WHERE role = '" + role + "';";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {
				Role r = new Role();
				r.setRoleId(result.getInt("roleid"));
				r.setRole(result.getString("role"));
				return r;
			} //end if block
			
		} //end try block
		
		catch (SQLException e) {
			e.printStackTrace();
		} //end catch block
		
		return null;
	} //end findByRole(role) method

	@Override
	public List<Role> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM roles;";
			Statement statement = conn.createStatement();
			List<Role> list = new ArrayList<>();
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				Role r = new Role();
				r.setRoleId(result.getInt("roleid"));
				r.setRole(result.getString("role"));
				list.add(r);
			} //end while loop
			
			System.out.println("role array loaded " + list.size() + " entries");
			return list;			
		} //end try block
		
		catch (SQLException e) {
			e.printStackTrace();
		} //end catch block
		
		return null;
	} //end findAll() method

	@Override
	public boolean insertRole(Role r) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			int index = 0;
			String sql = "INSERT INTO roles(role)" + " VALUES(?);";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(++index,  r.getRole());
			statement.execute();
			return true;
		} //end try block
		
		catch (SQLException e) {
			e.printStackTrace();
		} //end catch block
		
		return false;
	} //end insertRole(r) method

} //end RoldDAO class
