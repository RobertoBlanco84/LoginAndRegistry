package com.roberto.spring.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roberto.spring.model.bean.User;
import com.roberto.spring.model.validator.UserValidator;

@Controller
public class ValidatorController {
	
	/*
	@Autowired
	private UserValidator userValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}
	
	@GetMapping("/login")
	//@RequestMapping("/login")
	public String userForm(Locale locale, Model model, User user) {
		System.out.println("YOOoooOOOOOo FORM BINDER CHECK FIELDS METHOD");
		model.addAttribute("userName", user.getUserName());
		model.addAttribute("password", user.getPassword());
		System.out.println("USR FORM BINDER CHECK FIELDS METHOD");
		return "pages/login";	
		//return "pages/login";
	} */
	
	/**
	 * Save user object
	 */
	
	/*@PostMapping("/saveUser")
	public String saveUser (@ModelAttribute("user") @Validated User user, BindingResult result,
			Model model) {
		
		if(result.hasErrors()) {
			return "userForm";
		}
		return "success";
	} */

}
