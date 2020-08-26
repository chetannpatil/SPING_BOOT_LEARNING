package com.JsonRespForWhiteLabelErro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController 
{

	@GetMapping(value = "/welcome")
	public String getWord()
	{
		System.out.println("HWC getWord\n");
		
		return "Hi helllow rold Chetan";
	}
}
