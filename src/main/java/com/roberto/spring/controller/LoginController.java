package com.roberto.spring.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roberto.spring.model.bean.User;
import com.roberto.spring.model.validator.UserValidator;

@Controller
public class LoginController {

	@Autowired
	private UserValidator userValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}

	@GetMapping("/")
	public String submit( ModelMap model/*, User user*/) {
		//model.addAttribute("userName", user.getUserName());
		//model.addAttribute("password", user.getPassword()); 
		System.out.println("In first getMapping");
		model.addAttribute("userForm", new User());
		return "pages/login";
	}

	
	@PostMapping("/login")
	public String saveUser(@ModelAttribute("userForm") @Validated User user, BindingResult result,
			Model model) {
		System.out.println("In first PostMapping");
		if (result.hasErrors()) {
			return "pages/login";
		}
		model.addAttribute("userName", user.getUserName());
	//	model.addAttribute("password", user.getPassword());
		System.out.println("About to return pages/profile");
		return "redirect:profile";
	}
	
}
