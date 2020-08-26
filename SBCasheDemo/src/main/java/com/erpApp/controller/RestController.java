package com.erpApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.erpApp.model.User;

import com.erpApp.service.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController
{
	@Autowired
	private UserService userService;

	
	
	@GetMapping(value = "/getByLastName/{lastName}")
	public List<User> findByLastName(@PathVariable("lastName") String lastName)
	{
		return userService.findByLastName(lastName);
	}
	
	@GetMapping(value = "/")
	public List<User> findByLastName2()
	{
		String lastName = "Patil";
		return userService.findByLastName(lastName);
	}

	@GetMapping(value = "/get/{firstName}/{email}")
	public List<User> findByFirstNameAndEmail(@PathVariable("email") String email,
			@PathVariable("firstName") String firstName)
	{
		return userService.findByFirstNameAndEmail(firstName,email);
	}
	
	@GetMapping(value = "/get/{email}")
	public List<User> findByEmail(@PathVariable("email") String email)
	{
		return userService.searchByEmail(email);
	}
	
	
	//fetchByFNameAndEmail
	
	/*
	 * @GetMapping(value = "/fetch/{firstName}/{email}") public List<User>
	 * fetchByFirstNameAndEmail(@PathVariable("email") String email,
	 * 
	 * @PathVariable("firstName") String firstName) {
	 * System.out.println("RC fetchBy fn ="+firstName+"  & email = "+email+"\n");
	 * return userService.fetchByFirstNameAndEmail(firstName, email); }
	 */
	
	//getByEmailAndAdhar
	@GetMapping(value = "/find/{email}/{adharNumber}")
	public List<User> getByEmailAndAdhar(@PathVariable("email") String email,
			@PathVariable("adharNumber") String adharNumber)
	{
		System.out.println("RC fetchByfn & email");
		return userService.getByEmailAndAdhar(email,adharNumber);
	}
	
	//public  ()
	@GetMapping(value = "/find/{adharNumber}")
	public User getByAdhar(@PathVariable("adharNumber") String adharNumber)
	{
		return userService.getByAdhar(adharNumber);
	}
	
	@DeleteMapping(value = "/delete/{adharNumber}")
	public void deleteByAdhar(@PathVariable("adharNumber") String adharNumber)
	{
		System.out.println("\n RC deleteByAdhar with adhr = \n"+adharNumber);
		 userService.deleteByAdhar(adharNumber);
	}
	
	@PutMapping(value = "/update/{adharNumber}")
	public User updateByAdhar(@PathVariable("adharNumber") String adharNumber,
			@RequestBody User newUser)
	{
		System.out.println("\n RC updateByAdhar with adhr = \n"+adharNumber);
		return  userService.updateByAdhar(adharNumber,newUser);
	}
	
	//extra
	
	//delete by @query
	@DeleteMapping(value = "/truncate/{adharNumber}")
	public void truncateByAdhar(@PathVariable("adharNumber") String adharNumber)
	{
		System.out.println("\n RC truncateByAdhar with adhr = \n"+adharNumber);
		 userService.truncateByAdhar(adharNumber);
	}
	
	//delete by native  @query 
	@DeleteMapping(value = "/drop/{adharNumber}")
	public void dropByAdhar(@PathVariable("adharNumber") String adharNumber)
	{
		System.out.println("\n RC dropByAdhar with adhr = \n"+adharNumber);
		 userService.dropByAdhar(adharNumber);
	}
}
