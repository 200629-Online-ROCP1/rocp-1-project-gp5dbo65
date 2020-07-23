/* User.java */

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

	/***********************
	 * Getters and Setters *
	 ***********************/
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

	/**********************
	 *  User Constructors *
	 **********************/
	public User() {
		super();
	} //end no-arg User Constructor
		
	public User(String username, String password, String firstName, String lastName, String email, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.acctList.clear();
	} //end 6-arg User Constructor : No userId & acctList provided 
	
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
	} //end 6-arg User Constructor: No Role & acctList provided

	public User(String username, String password, String firstName, String lastName, String email, Role role,
			List<Account> acctList) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.acctList = acctList;
	} //end 7-arg User Constructor : No userId provided

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	} //end hashCode() method

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	} //end equals(obj) method
	
} //end User class