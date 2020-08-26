package io.chetan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import io.chetan.dao.UserDao;
import io.chetan.model.User;

@SpringBootApplication
public class JerseySpringbootApplication implements CommandLineRunner
{

	 @Autowired
	 private UserDao userDao ;
	 
	public static void main(String[] args)
	{
		System.out.println("\n JerseySpringbootApplication  main strted\n");
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(JerseySpringbootApplication.class, args);
		
		
		/*
		 * UserDao userDao = configurableApplicationContext.getBean("userDao",
		 * UserDao.class );
		 * 
		 * User u1 = new User(); u1.setFirstName("C"); u1.setLastName("P");
		 * userDao.createUser(u1);
		 */
		 
		System.out.println("\n JerseySpringbootApplication  main ended \n");
	}
	
	  @Override public void run(String... args) throws Exception {
	  System.out.println("\n JerseySpringbootApplication  run\n");
	  
	  
	  User u1 = new User(); u1.setFirstName("C"); u1.setLastName("P"); //
	  userDao.createUser(u1);
	  
	  }
	 
}
