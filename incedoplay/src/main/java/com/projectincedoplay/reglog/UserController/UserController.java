package com.projectincedoplay.reglog.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectincedoplay.reglog.UserService;
import com.projectincedoplay.reglog.UserEntitya.User;
import com.projectincedoplay.reglog.UserPojo.UserPojo;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getuserdetails")
	public List<User> getUserInfo() {
		return userService.getUser();
	}

	@PostMapping("/register")
	public String getUserInfo(@RequestBody UserPojo pojo) {
		return userService.saveUser(pojo);
	}
	
	
	@PostMapping("/login")
	public String UserLogin(@RequestBody UserPojo pojo) {
		
		return userService.authenticate(pojo);
	}
}

