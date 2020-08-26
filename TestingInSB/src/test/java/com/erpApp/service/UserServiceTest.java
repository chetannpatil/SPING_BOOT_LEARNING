package com.erpApp.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.erpApp.dao.UserDao;
import com.erpApp.model.User;

@SpringBootTest
class UserServiceTest 
{
	@MockBean
	private UserDao userDao ;

	@Autowired
	private UserService userService;
	

	@Test
	void testCreateUser()
	{
		System.out.println("\n UserServiceTest testCreateUser\n");
		
		User u1 = new User();
		u1.setUserId(22);
		u1.setAdharNumber("1");
		u1.setEmail("c@c.com");
		u1.setFirstName("dweep");
		u1.setLastName("kalmath");
		
		Mockito.when(userDao.save(u1)).thenReturn(u1);
		
		assertThat(userService.createUser(u1)).isEqualTo(u1);
		
		
	}

	@Test
	void testFindUserById()
	{
		System.out.println("\n UserServiceTest testFindUserById\n");
		long id = 22;
		User u1 = new User();
		
		u1.setUserId(id);
		u1.setAdharNumber("145");
		u1.setEmail("c234@c.com");
		u1.setFirstName("fatima dweep");
		u1.setLastName("kalmath");
		
		
		User userByMockito = userDao.findById(id).get();
		
		System.out.println("b4 mocking u= \n "+u1+"\n userByMockito =  \n"+userByMockito);
		
		Mockito.when(userDao.findById(id).get()).thenReturn(u1);
		System.out.println("after mocking u= \n "+u1+"\n userByMockito =  \n"+userByMockito);
		
		User userBySevrvicId = userService.findUserById(id);
		System.out.println("\n userBySevrvicId = \n"+userBySevrvicId);
		assertThat(userService.findUserById(id)).isEqualTo(u1);
	}
}
