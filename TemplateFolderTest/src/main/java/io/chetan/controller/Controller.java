package io.chetan.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping(value = "/")
	public String home()
	{
		return "index";
	}
	@GetMapping(value = "/main")
	public String main()
	{
		return "main";
	}
}
