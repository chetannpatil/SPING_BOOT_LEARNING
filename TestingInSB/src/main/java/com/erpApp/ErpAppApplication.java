package com.erpApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.erpApp.model.User;
import com.erpApp.service.UserService;

@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class})
public class ErpAppApplication {

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ErpAppApplication.class, args);
		
		UserService userService = applicationContext.getBean("userService", UserService.class);
		
		//creating & inserting few users
				User user1 = new User();
				
				user1.setAdharNumber("1235");
				user1.setEmail("K@gmail.com");
				user1.setFirstName("VIRAT");
				user1.setLastName("KOHLI");
				user1.setKYCVerified(true);
				
				//user2 
				User user2 = new User();
				user2.setAdharNumber("6567");
				user2.setEmail("g@gmail.com");
				user2.setFirstName("geetha");
				user2.setLastName("Patil");
				user2.setKYCVerified(true);
				
				//user3 
				User user3 = new User();
				user3.setAdharNumber("5678");
				user3.setEmail("pt@gmail.com");
				user3.setFirstName("Chetan");
				user3.setKYCVerified(false);
				user3.setLastName("Patil");
				
				//user4 
				User user4 = new User();
				user4.setAdharNumber("1234");
				user4.setEmail("v@gmail.com");
				user4.setFirstName("vikram");
				user4.setKYCVerified(true);
				user4.setLastName("Patil");
				
				//create all users
				userService.createUser(user1);
				userService.createUser(user2);
				userService.createUser(user3);
				userService.createUser(user4);
				System.out.println("erppp nain after creating all user");
				
				
				
	}

}
