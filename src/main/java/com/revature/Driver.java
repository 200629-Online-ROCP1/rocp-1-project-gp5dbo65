/**
 * 
 */
package com.revature;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.models.Account;
import com.revature.models.AccountStatus;
import com.revature.models.AccountType;
import com.revature.models.Role;
import com.revature.models.User;

/**
 * @author David Otis
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		// built Checking & Savings Type Objects
		AccountType acct_Checking = buildAccountTypeObject(1);		
		AccountType acct_Savings  = buildAccountTypeObject(2);		
		System.out.println("Checking Account : " + acct_Checking.toString());		
		System.out.println("Savings Account  : " + acct_Savings.toString());
		
		//build Account Status Objects
		AccountStatus acct_Pending = buildAccountStatusObject(1);
		AccountStatus acct_Open    = buildAccountStatusObject(2);
		AccountStatus acct_Closed  = buildAccountStatusObject(3);
		AccountStatus acct_Denied  = buildAccountStatusObject(4);
		System.out.println("Account Pending : " + acct_Pending.toString());
		System.out.println("Account Open    : " + acct_Open.toString());
		System.out.println("Account Closed  : " + acct_Closed.toString());
		System.out.println("Account Denied  : " + acct_Denied.toString());
		
		//build Account Objects
		Account acct_Check_Pend = buildAccountObject(1001, 100.0d, acct_Pending, acct_Checking);
		Account acct_Savin_Pend = buildAccountObject(2001, 100.0d, acct_Pending, acct_Savings);
		Account acct_Check_Open = buildAccountObject(1002, 100.0d, acct_Open, acct_Checking);
		Account acct_Savin_Open = buildAccountObject(2002, 100.0d, acct_Open, acct_Savings);
		Account acct_Check_Clos = buildAccountObject(1003, 0.0d, acct_Closed, acct_Checking);
		Account acct_Savin_Clos = buildAccountObject(2003, 0.0d, acct_Closed, acct_Savings);
		Account acct_Check_Deny = buildAccountObject(1004, 0.0d, acct_Denied, acct_Checking);
		Account acct_Savin_Deny = buildAccountObject(2004, 0.0d, acct_Denied, acct_Savings);

		System.out.println("Checking Pending : " + acct_Check_Pend.toString());
		System.out.println("Checking Open    : " + acct_Check_Open.toString());
		System.out.println("Checking Closed  : " + acct_Check_Clos.toString());
		System.out.println("Checking Denied  : " + acct_Check_Deny.toString());
		
		System.out.println("Savings Pending  : " + acct_Savin_Pend.toString());
		System.out.println("Savings Open     : " + acct_Savin_Open.toString());
		System.out.println("Savings Closed   : " + acct_Savin_Clos.toString());
		System.out.println("Savings Denied   : " + acct_Savin_Deny.toString());
		
		//build Role Objects
		Role role_Admin    = buildRoleObject(1);
		Role role_Employee = buildRoleObject(2);
		Role role_Standard = buildRoleObject(3);
		Role role_Premium  = buildRoleObject(4);

		System.out.println("Role Admin    : " + role_Admin.toString());
		System.out.println("Role Employee : " + role_Employee.toString());
		System.out.println("Role Standard : " + role_Standard.toString());
		System.out.println("Role Premium  : " + role_Premium.toString());
		
		//build User Objects
		

	} //end main method
	

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/...";
		String username = "postgres";
		String password = "password";
		
		return DriverManager.getConnection(url, username, password);
	} //end getConnection() method

	
	
	
	public static User buildUserObject() {
		User userObj = new User();
		
		return userObj;
	} //end buildUserObject() method
	
	public static Role buildRoleObject(int i) {
		Role roleType = new Role(i);
		switch (i) {
			case 1 :
				roleType.setRole("Admin");
				break;
			case 2 :
				roleType.setRole("Employee");
				break;
			case 3 :
				roleType.setRole("Standard");
				break;
			case 4 :
				roleType.setRole("Premium");
				break;
			default :
				//TODO throw some kind of exception for illeagle arguement
		} //end switch block

		return roleType;
	} //end buildRoleObject(int i) method
	
	public static Account buildAccountObject(int acctNum, double balance, AccountStatus acct_Status, 
			AccountType acct_type) {

		return new Account(acctNum, balance, acct_Status, acct_type);
	} //end Account method
	
	public static AccountStatus buildAccountStatusObject(int i) {
		AccountStatus acctStatus = new AccountStatus(i);
		switch (i) {
			case 1 :
				acctStatus.setStatus("Pending");
				break;
			case 2 :
				acctStatus.setStatus("Open");
				break;
			case 3 :
				acctStatus.setStatus("Closed");
				break;
			case 4 :
				acctStatus.setStatus("Denied");
				break;
			default :
				//TODO throw some kind of exception for illeagle arguement
		} //end switch block
		
		return acctStatus;
	} //end buildAccountStatusOject(int i) method

	public static AccountType buildAccountTypeObject(int i) {
		AccountType acctType = new AccountType(i);
		switch (i) {
			case 1 :
				acctType.setType("Checking");
				break;
			case 2 :
				acctType.setType("Savings");
				break;
		} //end switch block
		
		return acctType;
	} //end buildAccountTypeObject() method
	
} //end Driver class
