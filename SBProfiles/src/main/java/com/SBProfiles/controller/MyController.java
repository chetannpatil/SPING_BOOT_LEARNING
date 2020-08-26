package com.SBProfiles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SBProfiles.service.MessageService;

@RestController
public class MyController
{

	@Value("${welcome.message}")
	private String message ;
	
	@Autowired
	private MessageService messageService;
	
	
	
	@GetMapping(value = "/")
	public String getMessage()
	{
		System.out.println("\nMyController getMessage\n");
		return message;
	}
	
	@GetMapping(value = "/getXML")
	public String getMessageFromXML()
	{
		System.out.println("\nMyController getMessageFromXML\n");
		return messageService.getMessage();
	}
	
}
