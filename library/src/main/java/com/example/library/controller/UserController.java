package com.example.library.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.library.dto.UpdateUserRequest;
import com.example.library.dto.UserRequest;
import com.example.library.dto.UserResponse;
import com.example.library.service.IUserService;

import lombok.Data;

@RestController
@RequestScope
@RequestMapping("/users")
@CrossOrigin
@Validated
@Data
public class UserController {
	
	private final IUserService userService;
	
	
	@GetMapping("{identity}")
	public UserResponse findUserByIdentity(@PathVariable String identity ) {
		return userService.findUserByIdentity(identity);
	}
	
	@DeleteMapping("{identity}")
	public void deleteUserByIdentity(@PathVariable String identity) {
		 userService.deleteUserByIdentity(identity);
	}
	@PostMapping
	public UserResponse addUser(@RequestBody UserRequest user) {
		return userService.addUser(user);
	}
	
	@PutMapping (value="{identity}")
	public  UserResponse updateUser(@PathVariable String identity, @RequestBody UpdateUserRequest user) {
		return userService.updateUser(identity, user);
	}

}
