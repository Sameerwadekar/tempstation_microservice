package com.temp.userservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.temp.userservice.dao.RoleRepositary;
import com.temp.userservice.dao.UserRepositary;
import com.temp.userservice.dto.UserDto;
import com.temp.userservice.entities.AppRole;
import com.temp.userservice.entities.Role;
import com.temp.userservice.entities.User;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepositary userRepositary;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired 
	private RoleRepositary roleRepositary;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		Role role = roleRepositary.findByRoleName(AppRole.ROLE_USER).orElseThrow(()->new RuntimeException("Role Not Found"));
		user.setRole(role);
		User savedUser = userRepositary.save(user);
		UserDto userdto = modelMapper.map(savedUser, UserDto.class);
		return userdto;
	}

}
