/* Role.java */

package com.revature.models;

public class Role {
	private int roleId;		//primary key
	private String role;	//not null, unique
	
	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public Role() {
		super();
	} //end no-arg Role Constructor
	
	public Role(int roleId) {
		super();
		this.roleId = roleId;
		this.role = "";
	} //end 1-arg Role Constructor

	public Role(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	} //end 2-arg Role Constructor
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + roleId;
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
		Role other = (Role) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (roleId != other.roleId)
			return false;
		return true;
	} //end equals() method

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", role=" + role + "]";
	} //end toString() method
} //end Role class
