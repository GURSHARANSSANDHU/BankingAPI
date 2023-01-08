package com.example.BankingAPI.businessLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.example.BankingAPI.DAOLayer.DAO;
import com.example.BankingAPI.DataModelLayer.Account;
import com.example.BankingAPI.DataModelLayer.BalanceTransaction;
import com.example.BankingAPI.DataModelLayer.Customer;
import com.example.BankingAPI.ExceptionHandler.UserDefinedException;


@Service
public class ServiceClass implements Serve
{
	
	@Autowired
	DAO d1;
	public void add(Customer p) throws UserDefinedException
	{
		int flag = 0;
		List <Customer> l1 = this.d1.findAll();
		for(Customer q : l1)
		{
			if(q.getId() == p.getId())
			{
				flag = 1;
				break;
			}
		}
		if(flag == 0)
		{
			this.d1.save(p);
		}
		else if(flag == 1)
		{
			throw new UserDefinedException("THE USER YOU WANT TO CREATE IS ALREADY PRESENT IN THE DATABASE");
		}
	}
	@Override
	public List<Customer> All() throws UserDefinedException
	{
		// TODO Auto-generated method stub
		List <Customer> l1 = this.d1.findAll();
		if(l1 == null || l1.size() <= 0)
		{
			throw new UserDefinedException("NO CUSTOMER IS PRESENT IN THE DATABSE");
		}
		return l1;
	}
	@Override
	public Customer getOne(int id) throws UserDefinedException
	{
		
		int flag = 0;
		List <Customer> l2 = this.d1.findAll();
		Customer c = new Customer();
		for(Customer  p : l2)
		{
			if(id == p.getId())
			{
				c = p;
				flag = 1;
				break;
			}
		}
		if(flag == 0)
		{
			throw new UserDefinedException("NO USER EXISTS WITH THIS PARTICULAR ID");
		}
		
		return c;
		
		
	}
	@Override
	public void updateAccount(Customer c1) throws UserDefinedException 
	{
      int flag = 0;
	  List <Customer> l1 = this.d1.findAll();
	  Customer c = new Customer();
	  for(Customer p : l1)
	  {
		  if(p.getId() == c1.getId())
		  {
			  flag = 1;
			  c = p;
			  break;
		  }
		  
	  }
	  if(flag == 1)
	  {
	  for(Account q : c1.getL1())
	  {
		  c.getL1().add(q);
	  }
	  this.d1.save(c);
	  }
	  
	  else if(flag == 0)
	  {
		  throw new UserDefinedException("THE USER WHOSE DETAILS YOU WANT TO UPDATE IS ALREADY NOT PRESENT IN THE DATABASE");
	  }
	  
		
	}
	@Override
	public void trans(BalanceTransaction b1) 
	{
		
		 
		  List <Customer> l1 = this.d1.findAll();
		  Customer s = new Customer();
		  for(Customer p : l1)
		  {
			  if(p.getId() == b1.getSendersid())
			  {
				  s = p;
				  break;
			  }
		  }
		  Customer r = new Customer();
		  
		  for(Customer q : l1)
		  {
			  if(q.getId() == b1.getReceiverid())
			  {
				  r = q;
				  break;
			  }
		  }
		  List <Account> l3 = s.getL1();
		  
		  for(Account i : l3)
		  {
			  if(i.getAccno() == b1.getSendersacc())
			  {
				  i.setBalance(i.getBalance()-b1.getAmount());
				  break;
			  }
		  }
		  List <Account> l4 = r.getL1();
		  for(Account j : l4)
		  {
			  if(j.getAccno() == b1.getReceiveracc())
			  {
				  j.setBalance(j.getBalance()+b1.getAmount());
				  
			  }
		  }
		  Customer f1 = new Customer();
		  f1.setId(s.getId());
		  f1.setName(s.getName());
		  f1.setAddress(s.getAddress());
		  f1.setL1(l3);
		  Customer f2 = new Customer();
		  f2.setId(r.getId());
		  f2.setName(r.getName());
		  f2.setAddress(r.getAddress());
		  f2.setL1(l4);
		  this.d1.save(f1);
		  this.d1.save(f2);
		  
		  
	}
	
	public Customer searchName(String name) {
		return this.d1.findByName(name);
	}
	@Override
	public void delete(int id) 
	{
		// TODO Auto-generated method stu
		this.d1.deleteById(id);
		
	}
	
	
	
	

}
