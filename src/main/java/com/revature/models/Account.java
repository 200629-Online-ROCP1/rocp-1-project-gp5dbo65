package com.revature.models;

public class Account {
	private int accountId;		//primary key
	private double balance;		//not null
	private	AccountStatus status;
	private AccountType type;
	
	public int getAccountId() {
		return accountId;
	}
	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public AccountStatus getStatus() {
		return status;
	}
	
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	
	public AccountType getType() {
		return type;
	}
	
	public void setType(AccountType type) {
		this.type = type;
	}
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	} //end no-arg Account Constructor
	
	public Account(int accountId, double balance, AccountStatus status, AccountType type) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.status = status;
		this.type = type;
	} //end 4-arg Account Constructor

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", status=" + status + ", type=" + type
				+ "]";
	} //end toString() method	
	
} //end Account class
