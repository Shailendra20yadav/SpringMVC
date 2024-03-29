package com.sk.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sk.spring.model.EmployeeTeo;

@Component
public class LoginValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return EmployeeTeo.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.userForm.userName");
        
		
	}

}
