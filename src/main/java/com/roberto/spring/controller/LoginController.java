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

	//@GetMapping("/login")
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String submit(
			@ModelAttribute("userForm") @Validated User user,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			System.out.println("KUK HORA METOD");
			return "pages/login";
		}
		model.addAttribute("userName", user.getUserName());
		model.addAttribute("password", user.getPassword());
	
		System.out.println("IN login method!!!");

		return "pages/login";
	}
	
	/*@PostMapping("/login")
	   public String saveUser( @Valid User user, BindingResult result) {
		 System.out.println("SSAVE USER METHOD");
	      if (result.hasErrors()) {
	         return "pages/login";
	      }
	      System.out.println("HORA, jag börjar hata Spring MVC mer och mera");
	      return "pages/profile";
	   }   */
	

/*	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String error(User user) {
		System.out.println("BEFORE CHECK IN ERROR METHOD");
		if (user.getUserName().equals("") || user.getPassword().equals("")) {
			return "pages/login";
		}

		System.out.println("IN Error method!!!");

		return "pages/login";
	} */

}
