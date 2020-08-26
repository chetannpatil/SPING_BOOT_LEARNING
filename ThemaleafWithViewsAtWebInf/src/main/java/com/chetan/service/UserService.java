package com.chetan.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.chetan.model.User;

@Service
public class UserService 
{

	private List<User> usersList = new ArrayList<User>();

	public List<User> getAllUsers()
	{
		System.out.println("\n UserService getAllUsers\n");
		return usersList;
	}

	public void addUser( User user)
	{

		System.out.println("\n UserService addUser\n");
		
		usersList.add(user);
	}
	
	
}
