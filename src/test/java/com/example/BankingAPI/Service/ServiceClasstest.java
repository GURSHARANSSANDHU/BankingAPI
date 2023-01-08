package com.example.BankingAPI.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.BankingAPI.DAOLayer.DAO;
import com.example.BankingAPI.DataModelLayer.Account;
import com.example.BankingAPI.DataModelLayer.Customer;
import com.example.BankingAPI.ExceptionHandler.UserDefinedException;
import com.example.BankingAPI.businessLayer.ServiceClass;

@RunWith(SpringRunner.class)
@SpringBootTest
class ServiceClasstest {
     
	@Autowired
	private ServiceClass service;
	
	@MockBean
	private DAO repo;
	
	@Test
	public void getAllCustomertest() throws UserDefinedException {
		
		List<Customer> list=new ArrayList<Customer>();
		
		List<Account> Acc=new ArrayList<Account>();
		Account one=new Account(12,12345);
		Account two=new Account(1,3425234);
		Acc.add(one);
		Acc.add(two);
		
		Customer cust=new Customer(1,"gursh","punjab",Acc);
		
		list.add(cust);
		 
		when(repo.findAll()).thenReturn(list);
		
		
		List<Customer> custlist=service.All();
		
		assertEquals(1,custlist.size());
		
		
	
	}
	
	@Test
	public void createCustomerTest() throws UserDefinedException
	{
		List<Account> Acclist=new ArrayList<Account>();
		Account one=new Account(1,123);
		Account two=new Account(2,344);
		Acclist.add(one);
		Acclist.add(two);
		
		Customer cust=new Customer(1,"gursh","punjab",Acclist);
		
		service.add(cust);
		
		verify(repo,times(1)).save(cust);
	
		
		
	}
	
	
	

	

}
