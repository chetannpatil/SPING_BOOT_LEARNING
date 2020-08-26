package com.erpApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig 
{

	@Bean
	public Docket productApi()
	{
		System.out.println("\n SwaggerConfig productApi\n");
		 //.paths(PathSelectors.regex("/product.*")).build()
		return  new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(" com.erpApp.controller"))
				.paths(PathSelectors.regex("/product.*"))
				.build()
				.apiInfo(getMetadate());
		 
	}

	private ApiInfo getMetadate() 
	{
		System.out.println("\n SwaggerConfig getMetadate\n");
		
		ApiInfo apiInfo = new ApiInfo("SB rest api",
				"sb api 4 online strore",
				"2.0",
				"termsOfService",
				"18371289",
				"aazon license version 2.0", 
				"www.amazon.com/license");
		
		return apiInfo ;
	}
}
