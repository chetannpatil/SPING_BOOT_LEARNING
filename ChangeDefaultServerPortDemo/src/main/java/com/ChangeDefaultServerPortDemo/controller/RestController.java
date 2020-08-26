package com.ChangeDefaultServerPortDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.web.bind.annotation.RestController
public class RestController
{
	
	

	
	@GetMapping(value = "/")
	public String get()
	{
		System.out.println("RC get\n");
		return "hi";
	}
	  
	
	 


}
