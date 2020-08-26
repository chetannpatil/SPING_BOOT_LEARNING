package com.JsonRespForWhiteLabelError;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//@ComponentScan(basePackages = {"com.controller"})
@SpringBootApplication
@ComponentScan(basePackages = {"com.JsonRespForWhiteLabelErro.controller","com.JsonRespForWhiteLabelErro.model"})
public class JsonRespForWhiteLabelErrorApplication {

	public static void main(String[] args)
	{
		System.out.println("\nJsonRespForWhiteLabelErrorApplication main \n");
		SpringApplication.run(JsonRespForWhiteLabelErrorApplication.class, args);
	}

}
