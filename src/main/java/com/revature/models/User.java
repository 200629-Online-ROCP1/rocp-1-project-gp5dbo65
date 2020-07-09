package com.revature.models;

import java.util.List;

public class User {
	private int userId;			//primary key
	private String username;	//not null, unique
	private String password;	//not null
	private String firstName;	//not null
	private String lastName;	//not null
	private String email;		//not null
	private Role role;
	private List<Account> acctList; //List of Account objects
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public List<Account> getAcctList() {
		return acctList;
	}

	public void setAcctList(List<Account> acctList) {
		this.acctList = acctList;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	} //end no-arg User Constructor
	
	

	public User(int userId, String username, String password, String firstName, String lastName, String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = null;
		this.acctList.clear();
	} //end 6-arg User Constructor

	public User(int userId, String username, String password, String firstName, String lastName, String email,
			Role role, List<Account> acctList) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.acctList = acctList;
	} //end 8-arg User Constructor

	@Override
	public String toString() {
		String acctString = "";

		if (!acctList.isEmpty()) {
			for(Account strAcctList : acctList) {
				acctString.concat(", account=").concat(Integer.toString(strAcctList.getAccountId()));
			} //end for-each loop
			acctString.concat("]");
		} //end if block
		else {
			acctString = "]";
		} //end else block
			
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
		+ firstName + ", lastName=" + lastName + ", email=" + email + ", role=" + role + acctString;
		
	} //end toString() method
	
		

} //end User class