package com.supreet.springsecurity.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supreet.springsecurity.entity.AuthRequest;
import com.supreet.springsecurity.utils.JwtUtil;

@RestController
public class WelcomeController {
	
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to Java";
	}
	@GetMapping("/welcome1")
	public String welcome1() {
		return "Welcome to Java";
	}
	@GetMapping("/welcome2")
	public String welcome2() {
		return "Welcome to Java";
	}
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("test1234"+authRequest.toString()+"f");
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("Invalid Username OR Password");
		}
//		String host=request.getHeader("host");
//		host=host.substring(1,host.indexOf(":"));
		String ret=jwtUtil.generateToken(authRequest.getUserName());
//		Cookie cookie = new Cookie("token", ret);
//		cookie.setMaxAge(86400);
//		cookie.setSecure(false);
//		cookie.setHttpOnly(true);
//		cookie.setPath("/");
//		cookie.setDomain(host);
//		
//		//response.addHeader("access-control-expose-headers", "Set-Cookie");
//		//response.addHeader("Access-Control-Allow-Credentials", "true");
//		//response.addHeader("Access-Control-Allow-Origin", request.getHeader("host"));
//		response.addCookie(cookie);
//		
		return ret;
	}
}
