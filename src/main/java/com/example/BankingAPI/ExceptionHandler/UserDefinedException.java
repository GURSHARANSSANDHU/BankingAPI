package com.example.BankingAPI.ExceptionHandler;


@SuppressWarnings("serial")
public class UserDefinedException extends Exception 
{
	
	public UserDefinedException()
	{
		
	}
	public UserDefinedException(String s)
	{
		super(s);
		
	}
	

}
