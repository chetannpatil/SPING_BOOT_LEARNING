package com.ChangeDefaultServerPortDemo;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;
import org.springframework.web.context.WebApplicationContext;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

@Component
public class PortChanger implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
{
	/*
	 * @Override public void customize(WebServerFactory factory) {
	 * 
	 * factory.setPort }
	 */

	@Override
	public void customize(ConfigurableServletWebServerFactory factory)
	{

		factory.setPort(1988);
		factory.setContextPath("/empty/chetu");
	}



	
}
