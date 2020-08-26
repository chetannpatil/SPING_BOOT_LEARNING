package com.SBProfiles.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevProfileBean implements EnvBasedConfig
{

	@Override
	public void setUp() 
	{
		System.out.println("\n DevProfileBean setUp\n");
	}

}
