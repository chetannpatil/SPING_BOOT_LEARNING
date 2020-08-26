package com.erpApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;

@Configuration
public class HazleCastCinfig 
{

	@Bean
	public Config hazleConfig()
	{
	/*	Config config = new Config();
		 config.setInstanceName("hazlecast-instance");
		 
		 MapConfig mapConfig = new MapConfig().setName("usersCache");
		 
		  config.addMapConfig(mapConfig);
		   
		   MaxSizeConfig maxSizeConfig = new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE);
		   
		   config.setma*/
		Config config = new Config();
		 MaxSizeConfig maxSizeConfig = new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE);
		 MapConfig mapConfig = new MapConfig().setName("usersCache")
				                .setMaxSizeConfig(maxSizeConfig)
				                .setEvictionPolicy(EvictionPolicy.LRU)
				                .setTimeToLiveSeconds(2000);
	//	 MaxSizeConfig maxSizeConfig = new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE);
		 config.setInstanceName("hazlecast-instance")
				.addMapConfig(mapConfig);
		 
		 return config ;
				
	}
}

