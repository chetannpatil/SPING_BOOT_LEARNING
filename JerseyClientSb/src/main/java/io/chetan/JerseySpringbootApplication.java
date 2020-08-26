package io.chetan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import io.chetan.client.JerseyClient;

@SpringBootApplication
public class JerseySpringbootApplication {

	public static void main(String[] args)
	{
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(JerseySpringbootApplication.class, args);
	
		//JerseyClient jerseyClient = configurableApplicationContext.getBean(JerseyClient.class,"jerseyClient");
	
		//jerseyClient.main(args);
	}

}
