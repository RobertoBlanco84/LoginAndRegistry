package com.roberto.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roberto.spring.model.bean.User;

@Controller
public class ProfileController {

	
	@RequestMapping(value = "/profile")
	public String profile(@ModelAttribute("userForm") User user,
			BindingResult result, ModelMap model) {
		
		model.addAttribute("userName", user.getUserName());
		return "pages/profile";
	} 



}
