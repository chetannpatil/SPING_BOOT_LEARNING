package com.ChangeDefaultServerPortDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.tomcat.util.digester.SetPropertiesRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ChangeDefaultServerPortDemoApplication {

	public static void main(String[] args) 
	{
		//ConfigurableApplicationContext applicationContext = SpringApplication.run(ChangeDefaultServerPortDemoApplication.class, args);
		
		//applicationContext.s
		System.out.println("\n ChangeDefaultServerPortDemoApplication main\n ");
		
		SpringApplication sa = new SpringApplication(ChangeDefaultServerPortDemoApplication.class);
		
		System.out.println("sa = \n "+sa);
		/*
		 * Properties properties = new Properties(); properties.put("SERVER_PORT",
		 * 1947);
		 */
		
		
		/*
		 * Map<String, Object> dummyMap = new HashMap<>();
		 * 
		 * System.out.println("dummyMap.put(\"SERVER_PORT\", \"8585\") =\n "+dummyMap.
		 * put("SERVER_PORT", "8585"));
		 * System.out.println("dummyMap.put(\"SERVER_PORT\", 8585) =\n "+dummyMap.put(
		 * "SERVER_PORT", 8585));
		 * System.out.println("dummyMap.put(\"stringT\", string) =\n "+dummyMap.put(
		 * "name", "Chetan"));
		 */
		//map.put("SERVER_PORT", 1947);
		
		
		//setPort(sa);
		
		setContextPath(sa);
		sa.run(args);
		
		System.out.println("\n ChangeDefaultServerPortDemoApplication main afer sa.run()\n ");
		
		
		
	}

	private static void setPort(SpringApplication sa)
	{
 
		Map<String, Object> configMap = new HashMap<>();
		System.out.println("configMap.put(\"SERVER_PORT\", 8585) =\n "+configMap.put("SERVER_PORT", "8585"));
		System.out.println("configMap.put(\"SERVER_PORT\", 8585) =\n "+configMap.put("server.port", 1947));
		//sa.setDefaultProperties(properties);
	//	sa.setDefaultProperties(configMap);
		
		sa.setDefaultProperties(configMap);
		System.out.println("\n ChangeDefaultServerPortDemoApplication main afer sa.setDefaultProperties(configMap);\n ");
	}
	
	private static void setContextPath(SpringApplication sa)
	{
		Map<String, Object> configMap = new HashMap<>();
		configMap.put("server.servlet.context-path", "/via/spAppDefaultValues");
		
		sa.setDefaultProperties(configMap);
	}
}
