package com.kt.spring.demo.springdemo.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.kt.spring.demo.springdemo.auth.service.UserService;
import com.kt.spring.demo.springdemo.entity.Account;

public class UserValidator implements Validator {
	@Autowired
    private UserService userService;


	public UserValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Account.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		Account account=(Account)target;
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
	        if (account.getUsername().length() < 6 || account.getUsername().length() > 32) {
	            errors.rejectValue("username", "Size.userForm.username");
	        }
	        if (userService.findByUsername(account.getUsername()) != null) {
	            errors.rejectValue("username", "Duplicate.userForm.username");
	        }

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
	        if (account.getPassword().length() < 8 || account.getPassword().length() > 32) {
	            errors.rejectValue("password", "Size.userForm.password");
	        }

	        if (!account.getPassword().equals(account.getPassword())) {
	            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
	        }
		
	}

}
