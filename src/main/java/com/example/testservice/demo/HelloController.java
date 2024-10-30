package com.example.testservice.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testservice.CommonResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class HelloController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/users")
	public List<UserData> getUser() {
		return userService.getUsers();
	}

	// @PostMapping("/login")
	// public String login(@RequestParam(name = "name", required = false) String userName) {
	// 	System.err.println("name param: "+userName+"   : "+Thread.currentThread());
	// 	return userService.saveUser(userName);
	// }

	@PostMapping("/signup")
	public CommonResponse addUser(@RequestBody UserData user) {
		System.err.println("user: "+user);
		return userService.signup(user);
	}

}
