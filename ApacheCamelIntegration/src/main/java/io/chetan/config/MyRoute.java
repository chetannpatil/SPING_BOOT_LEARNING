package io.chetan.config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder
{

	@Override
	public void configure() throws Exception 
	{
		from("file:/media/chetan/WORK1/2019_NOV_STS_WORKSPACE/ApacheCamelIntegration/input")
		.to("file:/media/chetan/WORK1/2019_NOV_STS_WORKSPACE/ApacheCamelIntegration/output");
	}

}
