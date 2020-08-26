package com.erpApp;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLRunnerBean implements CommandLineRunner
{

	@Override
	public void run(String... args) throws Exception
	{

		System.out.println("\nCLRunnerBean run the values f args are as follws \n");
		
		System.out.println(Arrays.toString(args));;
	}

}
