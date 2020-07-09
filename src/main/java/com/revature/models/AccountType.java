package com.revature.models;

public class AccountType {
	private int typeId;		//primary key
	private String type;	// not null, unique
	
	enum type {
		Checking,
		Savings
	} //end type enumerations

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public AccountType() {
		super();
		// TODO Auto-generated constructor stub
	} //end no-arg AccountType Constructor

	public AccountType(int typeId) {
		super();
		this.typeId = typeId;
		this.type = "";
	} //end 1-arg AccountType Constructor

	public AccountType(int typeId, String type) {
		super();
		this.typeId = typeId;
		this.type = type;
	} //end 2-arg AccountType Constructor

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + typeId;
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
		AccountType other = (AccountType) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	} //end equals(Object obj) method

	@Override
	public String toString() {
		return "AccountType [typeId=" + typeId + ", type=" + type + "]";
	} //end toString() method
	
		
} //end of AccountType class
