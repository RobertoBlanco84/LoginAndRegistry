package com.roberto.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping(value = "/home")
	public String home(Model model) {
		System.out.println("IN INDEX METHOD");
		return "index";
	} 

}
