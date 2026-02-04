package com.temp.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temp.userservice.entities.User;

import java.util.Optional;


public interface UserRepositary extends JpaRepository<User, String> {
	Optional<User> findByEmail(String email);
	boolean existsByEmail(String email);
	
}
