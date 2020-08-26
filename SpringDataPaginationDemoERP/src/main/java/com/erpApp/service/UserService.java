package com.erpApp.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.erpApp.dao.UserDao;
import com.erpApp.model.User;

@Service
public class UserService 
{

	@Autowired
	private UserDao userDao ;
	
	
	public void createUser(User userBean)
	{
		userDao.save(userBean);
	}


	public User find(String email) 
	{
		Iterable<User> allUsers = userDao.findAll();
	
		System.out.println("USerService find(email ) all users = \n"+allUsers);
		User user = null;
		for(User u:allUsers)
		{
			System.out.println("\n userService find(mail) user = \n "+u);
		  if(u.getEmail().equalsIgnoreCase(email))
		  {
			  System.out.println("\n userService find(mail) user found and user = \n "+u);
             user = u;
			  
		  }
			  
		}
		System.out.println("\nuserService find(mail) after for loop ");
		return user;
	}

	public User findByKYC(String adharNumber)
	{
		Iterable<User> allUsers = userDao.findAll();
		for(User u:allUsers)
		{
			if(u.getAdharNumber().equalsIgnoreCase(adharNumber))
				return u;
		}
		return null;
	}
	
	public Iterable<User> findAllUsers()
	{
		return userDao.findAll();
	}


	public void updateUser(User userBean) 
	{
		userDao.save(userBean);
	}


	public List<User> getUsersByLastName(String lastName, Pageable p) 
	{
		return userDao.getUsersByLastName(lastName,p);
	}


	public List<User> findUsersByLastName(String lastName, PageRequest of)
	{
		return userDao.findUsersByLastName(lastName,of);
	}

	/*
	 * public List<User> fetchUsersByLastName(String lastName, PageRequest of) {
	 * return userDao.fetchUsersByLastName(lastName,of); }
	 */


	/*
	 * public List<User> fetchUsersByf_name(String firstName, PageRequest of) {
	 * return userDao.fetchUsersByf_name(firstName,of); }
	 */


	public List<User> getUsersByfirstName(String firstName, PageRequest of) 
	{
		return userDao.getUsersByfirstName(firstName,of);
	}


	public CompletableFuture<User> getUsersByfirstName(String firstName) 
	{
		System.out.println("Userservice getUsersByfirstName(String firstName) \n ");
		return userDao.getUsersByfirstName(firstName);
	}


	public List<User> getUsersByfirstNameOrLastName(String firstName, String lastName) 
	{
		return userDao.getUsersByfirstNameOrLastName(firstName,lastName);
	}


	public int updateUserF_nameByEmail(String email, String firstName) 
	{
		System.out.println("\n Uservice updateUserF_nameByEmail \n ");
		return userDao.updateUserF_nameByEmail(email,firstName);
	}


	public int updateUserLastNameByEmail(String email, String lastName) 
	{
		System.out.println("\n Uservice updateUserLastNameByEmail \n ");
		return userDao.updateUserLastNameByEmail(email,lastName);
	}



}
