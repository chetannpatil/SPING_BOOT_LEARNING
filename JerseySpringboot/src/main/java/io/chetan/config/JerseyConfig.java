package io.chetan.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import io.chetan.service.UserRestService;

@Component
public class JerseyConfig extends ResourceConfig
{

	public JerseyConfig()
	{
		System.out.println("\n JerseyConfig JerseyConfig()  \n");
		register(UserRestService.class);
	}

}
