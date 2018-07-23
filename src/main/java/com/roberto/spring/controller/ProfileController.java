package com.roberto.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roberto.spring.model.bean.Userz;

@Controller
public class ProfileController {

	@RequestMapping(value = "/profile")
	public String profile(@ModelAttribute("userForm") Userz user
			/*BindingResult result, ModelMap model*/) {
		System.out.println("IN PROFILE CONTROLLER METH"); 
		//model.addAttribute("userName", user.getUserName());
		return "pages/profile";
	} 

}
