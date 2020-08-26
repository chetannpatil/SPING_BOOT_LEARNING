package io.chetan.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.chetan.model.Owner;




@Controller
@RequestMapping(value = "/mypg")
public class OwnerController 
{
	/*
	 * @GetMapping("/") public ModelAndView welcome() {
	 * System.out.println("\n OwnerController welcome()"); ModelAndView modelAndView
	 * = new ModelAndView();
	 * 
	 * modelAndView.setViewName("Welcome");
	 * //modelAndView.addObject("signOutMessage", "Chetan's  signOutMessage");
	 * return modelAndView; }
	 * 
	 * @GetMapping("/contactMe") public ModelAndView contact() {
	 * 
	 * ModelAndView modelAndView = new ModelAndView();
	 * 
	 * modelAndView.setViewName("Contact");
	 * 
	 * return modelAndView;
	 * 
	 * }
	 */


	        @GetMapping("/registerPGOwner")
			public ModelAndView openPGOwnerRegistrationView()
			{
	        	ModelAndView modelAndView = new ModelAndView();
				Owner owner = new Owner();
				//Owner owner = new Owner();
				modelAndView.addObject("owner", owner);
				
				
				modelAndView.setViewName("createuser");
				
				
				
				
				return modelAndView ;
			}


	    	@PostMapping(value="/registerPGOwner")
	    	public ModelAndView registerPGOwner(@Valid Owner owner,
	    			BindingResult br)
	    	{
	    		System.out.println("\n OwnerController registerPGOwner()\n");
	    		ModelAndView modelAndView = new ModelAndView();
	    		modelAndView.setViewName("createuser");
	    		if(br.hasErrors())
	    		{
	    			
	    			
	    			
	    			modelAndView.addObject("owner",owner);
	    		 		
	    			
	    		}
	    		else
	    		{
			
	    			
                  //  modelAndView.setViewName("createuser");
	    			
	    		//	/modelAndView.addObject("pgowner2",pgowner2);
	    			
	    			modelAndView.addObject("owner",owner);	
	    			
	    		}
	    		return modelAndView ;
	    	}
	    	
	 
	  
	        
}
