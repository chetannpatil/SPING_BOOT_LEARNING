package io.chetan.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class HibernateUtilConfig 
{
 	@Autowired
	private EntityManagerFactory entityManagerFactory ;
	
	  @Bean
	  public SessionFactory getMySessionFactory() 
	  {
	  System.out.println("\n HibernateUtilConfig getSessionFactory  \n");
	  if(entityManagerFactory != null)
	  {
	  if(entityManagerFactory.unwrap(SessionFactory.class) == null)
	  {
	  System.out.println("\n HibernateUtilConfig getSessionFactory " +
	  " entityManagerFactory.unwrap(SessionFactory.class) is NULL \n"); 
	  throw new 	  NullPointerException("Factory is not hibernate factory"); 
	  }
	  return
	  entityManagerFactory.unwrap(SessionFactory.class); 
	  }
	  else
	  {
		  System.out.println("\n HibernateUtilConfig getSessionFactory  entityManagerFactory = null \n"
	  );
	  
	  return null ;
	  }
	  
	  
	  
	  }
	 

}
