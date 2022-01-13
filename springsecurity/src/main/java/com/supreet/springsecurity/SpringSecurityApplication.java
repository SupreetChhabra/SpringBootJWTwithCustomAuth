package com.supreet.springsecurity;

import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.supreet.springsecurity.entity.User;
import com.supreet.springsecurity.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityApplication {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void initUser() {
		User users = new User(101, "Supreet", "password", "abcd@in.com");
		userRepository.save(users);
	}
	

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

}
