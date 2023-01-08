package com.example.BankingAPI.controller;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.BankingAPI.businessLayer.ServiceClass;


@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
class ControlleTest {
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private ServiceClass service;

	@Test
	public void Helloworld()  throws Exception
	{
		RequestBuilder request=MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcresult=mockmvc.perform(request).andReturn(); 
		assertEquals("Hello world",mvcresult.getResponse().getContentAsString());
	}
	

}
