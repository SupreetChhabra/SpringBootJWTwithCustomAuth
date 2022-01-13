package com.supreet.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supreet.springsecurity.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String username);
	
	

} 
