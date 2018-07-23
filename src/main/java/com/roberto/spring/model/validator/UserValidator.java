package com.roberto.spring.model.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.roberto.spring.model.bean.Userz;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Userz.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors err) {
		//ValidationUtils.rejectIfEmpty(err, "userName", "user.name.empty");
		//ValidationUtils.rejectIfEmpty(err, "password", "password.empty");
		ValidationUtils.rejectIfEmpty(err, "userName", "testOne");
		ValidationUtils.rejectIfEmpty(err, "password", "testTwo");
		
		//User user = (User) obj;
	}

}
