package com.chetan.swaggerDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

	
	@RequestMapping(value = "/hello")
	public String hello()
	{
		System.out.println("\nRC getMessage \n");
		return "Hi from swagger app a greetings :)";
	}
}
