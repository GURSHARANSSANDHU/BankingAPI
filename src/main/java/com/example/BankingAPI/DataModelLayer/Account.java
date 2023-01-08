package com.example.BankingAPI.DataModelLayer;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Account 
{
	@Id  //Primary Key
	int accno;
	long balance;
	
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) 
	{
	   	this.balance = balance;
	   	
	}
	public Account(int accno, long balance) {
		super();
		this.accno = accno;
		this.balance = balance;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
