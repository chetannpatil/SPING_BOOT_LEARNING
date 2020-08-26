package com.erpApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


	public List<User> findByLastName(String lastName)
	{
		return userDao.findByLastName(lastName);
	}


	public List<User> findByFirstNameAndEmail(String firstName, String email) 
	{
		return userDao.findByFirstNameAndEmail(firstName, email);
		
	}
	
	public List<User> searchByEmail(String email)
	{
		return userDao.searchByEmail(email);
	}
	
	/*
	 * public List<User> fetchByFirstNameAndEmail(String firstName,String email) {
	 * System.out.println("userservice findByEmailAndFname"); return
	 * userDao.fetchByFirstNameAndEmail(firstName, email); }
	 */


	public List<User> getByEmailAndAdhar(String email, String adharNumber)
	{
		return userDao.getByEmailAndAdharNumber(email,adharNumber);
	}


	public User getByAdhar(String adharNumber)
	{
		System.out.println("U-service getByAdhar(String adharNumber) \n with adr = "+adharNumber);
		return userDao.getByAdhar(adharNumber);
	}
}
