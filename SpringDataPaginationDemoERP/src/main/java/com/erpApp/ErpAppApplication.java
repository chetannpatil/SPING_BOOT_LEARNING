package com.erpApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import com.erpApp.model.User;
import com.erpApp.service.UserService;

@SpringBootApplication
@EnableAsync
public class ErpAppApplication {

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ErpAppApplication.class, args);
		
		UserService userService = applicationContext.getBean("userService", UserService.class);
		
		//creating & inserting few users
				User user1 = new User();
				
				user1.setAdharNumber("1235");
				user1.setEmail("K@gmail.com");
				user1.setFirstName("Chetan");
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
				
				//user5 
				User user5 = new User();
				user5.setAdharNumber("65234");
				user5.setEmail("y@gmail.com");
				user5.setFirstName("YUKTI");
				user5.setKYCVerified(true);
				user5.setLastName("Patil");
				
				//use6 
				User user6= new User();
				user6.setAdharNumber("620234");
				user6.setEmail("m@gmail.com");
				user6.setFirstName("MUKTI");
				user6.setKYCVerified(true);
				user6.setLastName("Patil");
				
				//user7 
				User user7 = new User();
				user7.setAdharNumber("25678");
				user7.setEmail("rwe@gmail.com");
				user7.setFirstName("Chetan");
				user7.setKYCVerified(false);
				user7.setLastName("Gupta");
				
				//user8
				User user8 = new User();
				user8.setAdharNumber("25543678");
				user8.setEmail("rw34534e@gmail.com");
				user8.setFirstName("Chetan");
				user8.setKYCVerified(false);
				user8.setLastName("Pandey");
				
				//create all users
				userService.createUser(user1);
				userService.createUser(user2);
				userService.createUser(user3);
				userService.createUser(user4);
				userService.createUser(user5);
				userService.createUser(user6);
				userService.createUser(user7);
				userService.createUser(user8);
				System.out.println("erppp nain after creating all user");
				
				
				
	}

}
