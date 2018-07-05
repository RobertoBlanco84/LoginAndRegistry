package com.roberto.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roberto.spring.bean.User;

@Controller
public class indexController {
	

	@RequestMapping(value = "/home")
    public String home(Model model) {
		System.out.println("IN INDEX METHOD");
        return "index";
    } 
	
	/*@RequestMapping(value = "/login")
    public String login(Model model) {
		System.out.println("In LOGIN MEHTOD");
        return "pages/login";
    } */
	
	@GetMapping("/login")
    public String greetingForm(Model model) {
        model.addAttribute("login", new User());
        return "pages/login";
    }

    @PostMapping("/profile")
    public String greetingSubmit(@ModelAttribute User greeting) {
        return "pages/profile";
    }

	
	/*@RequestMapping(value = "/profile")
    public String profile(Model model) {
		System.out.println("In profile MEHTOD");
        return "pages/profile";
    }  */

}
