package com.revature.models;

public class AccountStatus {
	private int statusID;	//primary key
	private String status;	//not null, unique
		
	enum status {
		Pending,
		Open,
		Closed,
		Denied
	} //end AccountStatus enumeration

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AccountStatus() {
		super();
		// TODO Auto-generated constructor stub
	} //end no-arg AccountStatus Constructor

	public AccountStatus(int statusID) {
		super();
		this.statusID = statusID;
		this.status = "";
	} //end 1-arg AccountStatus Constructor

	public AccountStatus(int statusID, String status) {
		super();
		this.statusID = statusID;
		this.status = status;
	} //end 2-arg AccountStatus Constructor

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + statusID;
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
		AccountStatus other = (AccountStatus) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusID != other.statusID)
			return false;
		return true;
	} //end equals(Object obj) method

	@Override
	public String toString() {
		return "AccountStatus [statusID=" + statusID + ", status=" + status + "]";
	} //end toString() method
		
} //end AccountStatus class
