package com.erpApp.controller;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.erpApp.model.User;
import com.erpApp.service.UserService;
import org.springframework.data.domain.PageRequest;

@org.springframework.web.bind.annotation.RestController
public class RestController
{
	@Autowired
	private UserService userService;
	/*
	 * @GetMapping(value = "/get/{lastName}") public List<User>
	 * getUsersByLastName(@PathVariable("lastName") String lastName) { //PageRequest
	 * p = new Pa //return userService.getUsersByLastName(lastName, new PageReq);
	 * return userService.getUsersByLastName(lastName, PageRequest.of(0, 2));
	 * 
	 * }
	 */
	
	/*
	 * @GetMapping(value = "/find/{lastName}") public List<User>
	 * findUsersByLastName(@PathVariable("lastName") String lastName) {
	 * //PageRequest p = new Pa //return userService.getUsersByLastName(lastName,
	 * new PageReq); return userService.findUsersByLastName(lastName,
	 * PageRequest.of(1, 4, Direction.DESC, "firstName"));
	 * 
	 * }
	 */
	
	@GetMapping(value = "/find/{lastName}")
	public List<User> getUsersByLastName(@PathVariable("lastName") String lastName)
	{
		//PageRequest p = new Pa
		//return userService.getUsersByLastName(lastName, new PageReq);
		return userService.getUsersByLastName(lastName, PageRequest.of(0, 4, Direction.DESC, "firstName"));
		
	}
	/*
	 * @GetMapping(value = "/fetch/{firstName}") public List<User>
	 * fetchUsersByf_name(@PathVariable("firstName") String firstName) {
	 * //PageRequest p = new Pa //return userService.getUsersByLastName(lastName,
	 * new PageReq); return userService.fetchUsersByf_name(firstName,
	 * PageRequest.of(0, 4, Direction.ASC, "adharNumber"));
	 * 
	 * }
	 */
	
	@GetMapping(value = "/get/{firstName}")
	public List<User> getUsersByfirstName(@PathVariable("firstName") String firstName)
	{
		//PageRequest p = new Pa
		//return userService.getUsersByLastName(lastName, new PageReq);
		return userService.getUsersByfirstName(firstName, PageRequest.of(0, 4, Direction.ASC, "email"));
		
	}
	
	@GetMapping(value = "/fetch/{firstName}")
	public CompletableFuture<User> fetchUsersByfirstName(@PathVariable("firstName") String firstName)
	{
		//PageRequest p = new Pa
		//return userService.getUsersByLastName(lastName, new PageReq);
		  CompletableFuture<User> usersByfirstName = userService.getUsersByfirstName(firstName);
		  User user = null;
		try {
			user = usersByfirstName.get(20, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  System.out.println("user by timeunit = \n "+user);
		  
		  return usersByfirstName;
		  
	}
	
	@GetMapping(value = "/get/{firstName}/{lastName}")
	public List<User> getUsersByfirstNameOrLastName(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName)
	{
		//PageRequest p = new Pa
		//return userService.getUsersByLastName(lastName, new PageReq);
		return userService.getUsersByfirstNameOrLastName(firstName, lastName);
		
	}
	
	@PutMapping(value = "/update/{email}/{firstName}")
	public int updateUserF_nameByEmail(@PathVariable("email") String email,
			@PathVariable("firstName") String firstName)
	{
		//PageRequest p = new Pa
		//return userService.getUsersByLastName(lastName, new PageReq);
		//return userService.getUsersByfirstNameOrLastName(firstName, lastName);
		System.out.println("\n UC updateLastName \n ");
		int i = userService.updateUserF_nameByEmail(email,firstName);
		
		System.out.println("rows updatd = \n "+i);
		return i;
		
	}
	
	@PutMapping(value = "/put/{email}/{lastName}")
	public int updateUserLastNameByEmail(@PathVariable("email") String email,
			@PathVariable("lastName") String lastName)
	{
		//PageRequest p = new Pa
		//return userService.getUsersByLastName(lastName, new PageReq);
		//return userService.getUsersByfirstNameOrLastName(firstName, lastName);
		System.out.println("\n UC updateLastName \n ");
		int i = userService.updateUserLastNameByEmail(email,lastName);
		
		System.out.println("rows updatd = \n "+i);
		return i;
		
	}
	/*
	 * @GetMapping(value = "/getByLastName/{lastName}") public List<User>
	 * findByLastName(@PathVariable("lastName") String lastName) { return
	 * userService.findByLastName(lastName); }
	 * 
	 * @GetMapping(value = "/") public List<User> findByLastName2() { String
	 * lastName = "Patil"; return userService.findByLastName(lastName); }
	 * 
	 * @GetMapping(value = "/get/{firstName}/{email}") public List<User>
	 * findByFirstNameAndEmail(@PathVariable("email") String email,
	 * 
	 * @PathVariable("firstName") String firstName) { return
	 * userService.findByFirstNameAndEmail(firstName,email); }
	 * 
	 * @GetMapping(value = "/get/{email}") public List<User>
	 * findByEmail(@PathVariable("email") String email) { return
	 * userService.searchByEmail(email); }
	 */
	
	//fetchByFNameAndEmail
	
	/*
	 * @GetMapping(value = "/fetch/{firstName}/{email}") public List<User>
	 * fetchByFirstNameAndEmail(@PathVariable("email") String email,
	 * 
	 * @PathVariable("firstName") String firstName) {
	 * System.out.println("RC fetchBy fn ="+firstName+"  & email = "+email+"\n");
	 * return userService.fetchByFirstNameAndEmail(firstName, email); }
	 */
	
	/*
	 * //getByEmailAndAdhar
	 * 
	 * @GetMapping(value = "/find/{email}/{adharNumber}") public List<User>
	 * getByEmailAndAdhar(@PathVariable("email") String email,
	 * 
	 * @PathVariable("adharNumber") String adharNumber) {
	 * System.out.println("RC fetchByfn & email"); return
	 * userService.getByEmailAndAdhar(email,adharNumber); }
	 * 
	 * //public ()
	 * 
	 * @GetMapping(value = "/find/{adharNumber}") public User
	 * getByAdhar(@PathVariable("adharNumber") String adharNumber) { return
	 * userService.getByAdhar(adharNumber); }
	 */
	
	
}
