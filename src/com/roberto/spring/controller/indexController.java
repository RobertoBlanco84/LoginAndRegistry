package com.roberto.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
	

	@RequestMapping(value = "/home")
    public String index(Model model) {
		System.out.println("IN INDEX METHOD");
        return "index";
    } 
	
	@RequestMapping(value = "/profile")
    public String profile(Model model) {
		System.out.println("In PROFILE MEHTOD");
        return "profile";
    } 

}
