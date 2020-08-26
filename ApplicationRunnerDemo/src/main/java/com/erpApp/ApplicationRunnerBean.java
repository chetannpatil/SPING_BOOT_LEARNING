package com.erpApp;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(value = 1)
public class ApplicationRunnerBean implements ApplicationRunner
{

	@Override
	public void run(ApplicationArguments args) throws Exception 
	{

		System.out.println("\nvalue = 1 ApplicationRunnerBean run app  args are  \n");
		
		//System.out.println(args);
		/*
		 * for(ApplicationArguments a :args) {
		 * 
		 * }
		 */
	}

}
