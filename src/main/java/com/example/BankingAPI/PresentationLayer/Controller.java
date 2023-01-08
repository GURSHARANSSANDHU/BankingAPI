package com.example.BankingAPI.PresentationLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankingAPI.DataModelLayer.BalanceTransaction;
import com.example.BankingAPI.DataModelLayer.Customer;
import com.example.BankingAPI.ExceptionHandler.UserDefinedException;
import com.example.BankingAPI.businessLayer.Serve;

@RestController
public class Controller 
{
	@Autowired
	Serve s1;
	
	@GetMapping("/hello")
	public String  hello()
	{
		return "Hello world";
	}
	
	@PostMapping("/Account")
	public void addAccount(@RequestBody Customer c1) throws UserDefinedException
	{
		this.s1.add(c1);
		
	}
	@GetMapping("/Accounts")
	public List<Customer> getall() throws UserDefinedException
	{
		return this.s1.All();
	}
	@GetMapping("/Account/{id}")
	public Customer getSingle(@PathVariable int id) throws UserDefinedException
	{
		return this.s1.getOne(id);
	}
	@PutMapping("/Account")
	public void update(@RequestBody Customer c1) throws UserDefinedException
	{
		this.s1.updateAccount(c1);
	}
	@PutMapping("/BalanceTransfer")
	public void transfer(@RequestBody BalanceTransaction b1)
	{
		this.s1.trans(b1);
	}
	
	@GetMapping("/Account/name/{name}")
	public Customer getSingleName(@PathVariable String name) throws UserDefinedException
	{
		return this.s1.searchName(name);
	}
    
	@DeleteMapping("/Account/{id}")
	public void del(@PathVariable int id) 
	{
		 this.s1.delete(id);
	}
	
	

}
