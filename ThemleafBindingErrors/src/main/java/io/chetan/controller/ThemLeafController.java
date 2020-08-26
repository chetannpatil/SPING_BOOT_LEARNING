package io.chetan.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.chetan.model.Owner;
import io.chetan.service.OwnerService;

@Controller
@RequestMapping(value = "/thymleaf")
public class ThemLeafController {

	@Autowired
	private OwnerService ownerService;

	@GetMapping(value = "/createOwner")
	public ModelAndView openCreateOwneerView()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CreateOwner");
		modelAndView.addObject("owner", new Owner());
		return modelAndView ;
	}
	
	@PostMapping(value = "/createOwner")
	public ModelAndView createOwneer(@Valid Owner owner ,BindingResult br)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CreateOwner");
		if(br.hasErrors())
		{
			System.out.println("br.hasErrors \n ");
			modelAndView.addObject("owner", owner);
		}
		else
		{
			 List<Owner> ownerslist = ownerService.findByPhoneNumber(owner.getPhoneNumber());
			 
			 System.out.println("ownlist = \n "+ownerslist);
			 
			 for(Owner o:ownerslist)
			 {
				 System.out.println("o = \n "+o);
			 }
			 
			 if(ownerslist == null || ownerslist.size() == 0)
			 {
				 System.out.println("not exist so crating\n");
				 ownerService.createOwner(owner);
			 }
		}
		
		return modelAndView ;
	}
	
}
