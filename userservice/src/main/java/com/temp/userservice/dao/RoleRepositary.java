package com.temp.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temp.userservice.entities.AppRole;
import com.temp.userservice.entities.Role;

import java.util.Optional;


public interface RoleRepositary extends JpaRepository<Role, Integer>{
	Optional<Role> findByRoleName(AppRole roleName);
}
