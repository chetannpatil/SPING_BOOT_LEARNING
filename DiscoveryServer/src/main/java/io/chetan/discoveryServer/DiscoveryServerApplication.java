package io.chetan.discoveryServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {

	public static void main(String[] args)
	{
		System.out.println("\n DiscoveryServerApplication main started");
		SpringApplication.run(DiscoveryServerApplication.class, args);
		System.out.println("\n DiscoveryServerApplication main ended\n ");

	}

}
