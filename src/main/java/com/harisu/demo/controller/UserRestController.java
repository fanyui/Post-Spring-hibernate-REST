package com.harisu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harisu.demo.entity.User;
import com.harisu.demo.entity.User;
import com.harisu.demo.service.UserService;
import com.harisu.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {
	// autowire the CustomerService
	@Autowired
	private UserService userService;

	// add mapping for GET /user
    @CrossOrigin(origins = "http://localhost:3000")

	@GetMapping("/user")
	public List<User> getUsers() {
		
		return userService.getUsers();
		
	}
	
	// add mapping for GET /user/{id}
	
	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable int id) {
		
		User user = userService.getUser(id);
		
		if (user == null) {
			throw new NotFoundException("User id not found - " + id);
		}
		
		return user;
	}
	
	// add mapping for POST /user  - add new user
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		
		user.setId(0);		
		userService.saveUser(user);
		
		return user;
	}
	
	// add mapping for PUT /user - update existing user
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		
		userService.saveUser(user);
		
		return user;
		
	}
	
	// add mapping for DELETE /customers/{customerId} - delete customer
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		
		User tempUser = userService.getUser(id);
		
		// throw exception if null
		
		if (tempUser == null) {
			throw new NotFoundException("User id not found - " + id);
		}
				
		userService.deleteUser(id);
		
		return "Deleted User id - " + id;
	}
	
}
