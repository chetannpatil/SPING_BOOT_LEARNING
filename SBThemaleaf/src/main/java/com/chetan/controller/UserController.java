package com.chetan.controller;



import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chetan.model.User;
import com.chetan.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController 
{

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	//like openUserView equivalent
	@GetMapping(value = "/createUser")
	public ModelAndView createUserView()
	{
		System.out.println("\n UserController createUserView\n");
		LOGGER.info("UserController createUser start ");
		ModelAndView modelAndView = new ModelAndView("createuser");
		
		//add userbean to modelAndView
		modelAndView.addObject("user", new User());
		
		//add profiles
		modelAndView.addObject("allProfiles", getProfiles());
		LOGGER.info("UserController createUser b4 return  ");
		return modelAndView ;
		
	}
	
	@PostMapping(value = "/createUser")
	public ModelAndView createUser(@Valid User user,BindingResult result)
	{
		System.out.println("\n UserController createUser\n");
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors())
		{
			LOGGER.info("Error in submittinf form so returning to createuser view ");
			modelAndView.setViewName("createuser");
			
			modelAndView.addObject("user",user);
			
			modelAndView.addObject("allProfiles", getProfiles());
			
			return modelAndView ;
		}
		
		userService.addUser(user);
		
		modelAndView.setViewName("userInfo");
		
		modelAndView.addObject("allUsers", userService.getAllUsers());
		LOGGER.info(" submittinf form suuscccsfullly ");
		return modelAndView ;
		
		
	}

	private List<String> getProfiles() 
	{
		LOGGER.info("UC getProfiles\n ");
		List<String> li = new ArrayList<String>();
		
		li.add("VP");
		li.add("AVP");
		li.add("Director");
		
		return li;
	}
}
