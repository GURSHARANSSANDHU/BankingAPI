package com.example.BankingAPI.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.BankingAPI.DataModelLayer.ExceptionEntity;

@ControllerAdvice
public class ExceptionsHandler 
{
	
	@ExceptionHandler(UserDefinedException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ResponseBody  ExceptionEntity exceptionfunction(UserDefinedException e1, HttpServletRequest request, HttpServletResponse response)
	{
		ExceptionEntity c = new ExceptionEntity();
		c.setMessage(e1.getMessage());
		c.setPath(request.getRequestURI());
		return c;
	}
	
	

}
