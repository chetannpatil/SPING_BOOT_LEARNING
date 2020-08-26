package com.SBProfiles;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import com.SBProfiles.config.EnvBasedConfig;

@SpringBootApplication
@ImportResource(value = "classpath:Beans.xml")
public class SbProfilesApplication implements CommandLineRunner{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	private EnvBasedConfig envBasedConfig ;
	
	public static void main(String[] args)
	{
		System.out.println("\nSbProfilesApplication run dsource =  \n");
		SpringApplication.run(SbProfilesApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception
	{
		System.out.println("\nSbProfilesApplication run dsource =  \n"+dataSource);
		System.out.println("\n  EnvBasedConfig setup is called = \n");
		envBasedConfig.setUp();
		
	}

}
