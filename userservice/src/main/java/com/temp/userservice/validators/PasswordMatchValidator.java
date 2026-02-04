package com.temp.userservice.validators;


import com.temp.userservice.dto.UserDto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, UserDto> {

	@Override
	public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return userDto.getPassword().equals(userDto.getConfirmPassword());
	}

}
