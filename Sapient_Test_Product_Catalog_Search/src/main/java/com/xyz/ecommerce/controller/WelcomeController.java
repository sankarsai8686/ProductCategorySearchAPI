package com.xyz.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping(value = {"/","/welcome","/index"})
	public String welcome()
	{
		return "Project Started Successfully !!!";
	}

}
