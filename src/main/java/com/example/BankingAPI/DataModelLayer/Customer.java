package com.example.BankingAPI.DataModelLayer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class Customer 
{
	@Id //Primary Key
	int id;
	String name;
	String address;
	@OneToMany(targetEntity=Account.class ,cascade=CascadeType.ALL)
	@JoinColumn(name="Customer_ID",referencedColumnName="id")
	List <Account> l1;
	public int getId() 
	{
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Account> getL1() {
		return l1;
	}
	public void setL1(List<Account> l1) {
		this.l1 = l1;
	}
	public Customer(int id, String name, String address, List<Account> l1) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.l1 = l1;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
