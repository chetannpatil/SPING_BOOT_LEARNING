package com.example.ActuaterTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ActuaterTestApplication
{

	private static final Logger LOGGER = LoggerFactory.getLogger(ActuaterTestApplication.class);
	
	private static final java.util.logging.Logger LOGGER_2 = java.util.logging.Logger.getLogger("myLogger");
	public static void main(String[] args)
	{
		SpringApplication.run(ActuaterTestApplication.class, args);
		//LOGGER.
		LOGGER.debug("SLF4j logger debug");
		LOGGER.warn("SLF4j logger warn");
		LOGGER.trace("SLF4j logger trace");
		LOGGER.error("SLF4j logger error");
		LOGGER.info("SLF4j logger info");
		
		LOGGER_2.info("Util logger info");
		//LOGGER_2.log(java.util.logging.Logger., msg);
	}

	@GetMapping(value = "/")
	public String get()
	{
		System.out.println("\n get()\n");
		String name = "Chetan";
		/*
		 * if(name.length() == 6) { throw new RuntimeException("excption happedn "); }
		 */
		return "Hi chetan how are you ?";
	}
	
}
