package com.example.testservice.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

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

	@PostMapping("/add_user")
	public String addUser(@RequestParam(name = "name", required = false) String userName) {
		System.err.println("name param: "+userName+"   : "+Thread.currentThread());
		return userService.saveUser(userName);
	}

}
