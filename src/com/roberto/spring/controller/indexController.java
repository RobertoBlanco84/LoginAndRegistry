package com.roberto.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

	/*@GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("userName", new User());
        model.addAttribute("password", new User());
        System.out.println("IN LOGIN");
        return "pages/login";
    }

    @PostMapping("/profile")
    public String greetingSubmit(@ModelAttribute User greeting) {
    	System.out.println("IN PROFILE");
        return "pages/profile";
    } */


	/*@RequestMapping(value = "/profile")
    public String profile(Model model) {
		System.out.println("In profile MEHTOD");
        return "pages/profile";
    }  */


	/*@ModelAttribute(value = "userForm")
	public User newEntity(){
	    return new User();
	} */

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String submit(
			@ModelAttribute("userForm") User user,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		model.addAttribute("userName", user.getUserName());
		model.addAttribute("password", user.getPassword());

		// employeeMap.put(employee.getId(), employee);
		System.out.println("IN login method!!!");

		return "pages/login";
	}
	
	@RequestMapping(value = "/profile")
	public String profile(@ModelAttribute("userForm") User user,
			BindingResult result, ModelMap model) {
		model.addAttribute("userName", user.getUserName());
		System.out.println("In profile MEHTOD");
		return "pages/profile";
	} 

	/*@RequestMapping(value = "/profile")
	public String profile(Model model) {
		System.out.println("In profile MEHTOD");
		return "pages/profile";
	} */

	/*@PostMapping("/profile")
	public String greetingSubmit(@ModelAttribute User userName) {
		System.out.println("IN PROFILE");
		return "pages/profile";
	} */

}
