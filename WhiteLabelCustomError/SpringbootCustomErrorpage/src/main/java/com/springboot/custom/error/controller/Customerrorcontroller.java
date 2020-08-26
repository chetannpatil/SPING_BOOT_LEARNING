package com.springboot.custom.error.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* 
 * To achieve the custom error logic for our spring boot application, developers must create 
 * a custom error controller that will implement the "ErrorController" interface. 
 * This interface provides a "getErrorPath()" method that developers will override to 
 * return a custom path that will be called when an error occurs.
 * 
 */
@Controller
public class Customerrorcontroller implements ErrorController {

	static final Logger LOGGER = LoggerFactory.getLogger(Customerrorcontroller.class);
	static final String PATH = "/error";

	@GetMapping(value= PATH)
	public String defaultErrorHandler() {
		LOGGER.info("Showing the custom error page.");
		return "404";		// In case of an error, this custom error page (404.html) will be rendered.
	}

	/*
	 * This method returns different error pages based on the error type.
	 */
	@Override
	public String getErrorPath() {
		return PATH;
	}
}
