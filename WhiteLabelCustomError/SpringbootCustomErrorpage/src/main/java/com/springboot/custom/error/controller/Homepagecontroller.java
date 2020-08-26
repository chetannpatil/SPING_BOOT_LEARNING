package com.springboot.custom.error.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/* 
 * A simple controller that will display the welcome information for this tutorial. On hitting the below URL in the browser,
 * the user will be shown the welcome contents of the home-page.html
 * 
 * URL - http://localhost:10091/
 * 
 */
@Controller
@RequestMapping(value = "/custom")
public class Homepagecontroller {

	static final Logger LOGGER = LoggerFactory.getLogger(Homepagecontroller.class);

	@GetMapping(value= "/")
	public String home() {
		LOGGER.info("Showing the home page.");
		return "home-page";		// Returns the home page of the application.
	}

}
