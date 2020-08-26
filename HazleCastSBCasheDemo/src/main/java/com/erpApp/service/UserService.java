package com.erpApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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


	@Cacheable(value = "usersCache",key = "#adharNumber",unless = "#result==null")
	public User getByAdhar(String adharNumber)
	{
		System.out.println("U-service getByAdhar(String adharNumber) \n with adr = "+adharNumber);
		return userDao.getByAdhar(adharNumber);
	}


	@CacheEvict(value = "usersCache",key = "#adharNumber")
	public void deleteByAdhar(String adharNumber) 
	{
		System.out.println("\nuserservie deleteByAdhar\n");
		Iterable<User> all = userDao.findAll();
		
		boolean found = false;
		for(User u:all)
		{
			if(u.getAdharNumber().equals(adharNumber))
			{
				System.out.println("gonna deleete user = \n "+u);
				userDao.delete(u.getUserId());
				//userDao.del
				found = true ;
				break;
			}
			
		}
		if(found == false)
		System.out.println("couldnt find "+adharNumber +" ered user to deleete  \n ");
	}


	@CachePut(value = "usersCache",key = "#adharNumber")
	public User updateByAdhar(String adharNumber, User newUser)
	{
		System.out.println("\nuserservie updateByAdhar\n");
		
		Iterable<User> allUsers = findAllUsers();
		
		for(User u:allUsers)
		{
			if(u.getAdharNumber().equals(adharNumber))
			{
				System.out.println("gonna update user = \n "+u);
				 return userDao.save(newUser);
				//userDao.del
				//break;
			}
			
		}
		System.out.println("couldnt find "+adharNumber +" ered user to update  \n ");
		return null;
		
	}


	public void truncateByAdhar(String adharNumber)
	{
		System.out.println("\nuserservie truncateByAdhar\n");
		
		userDao.truncateByAdhar(adharNumber);
	}


	public void dropByAdhar(String adharNumber)
	{
		System.out.println("\nuserservie dropByAdhar\n");
		userDao.dropByAdhar(adharNumber);
	}
}
