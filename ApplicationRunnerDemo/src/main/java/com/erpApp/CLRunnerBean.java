package com.erpApp;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 2)
public class CLRunnerBean implements CommandLineRunner
{

	@Override
	public void run(String... args) throws Exception
	{

		System.out.println("\nvalue = 2 CLRunnerBean run the values f args are as follws \n");
		
		System.out.println(Arrays.toString(args));;
	}

}
