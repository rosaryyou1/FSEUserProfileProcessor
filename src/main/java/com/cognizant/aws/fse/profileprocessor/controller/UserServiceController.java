package com.cognizant.aws.fse.profileprocessor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.aws.fse.profileprocessor.Json.domain.UserJsonModel;
import com.cognizant.aws.fse.profileprocessor.model.User;
import com.cognizant.aws.fse.profileprocessor.service.UserService;

@RestController
@RequestMapping("/skill-tracker/api/v1/engineer")
public class UserServiceController {

	@Autowired
	UserService userService;


	@PostMapping(path="/save-profile",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveUser(@RequestBody UserJsonModel usermodel) {
		String status = "{ status : success}";
		try {
			userService.saveUser(usermodel);
		} catch (Exception e) {
			status = e.getMessage();
		}
		return status;

	}
	
	@PostMapping(path="/update-profile",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateUser(@RequestBody User user) {
		String status = "{ status : success}";
		try {
			userService.updateUser(user);
		} catch (Exception e) {
			status = e.getMessage();
		}
		return status;

	}
	
	@GetMapping(value="/users/{userId}")
	public User getUserByUserId(@PathVariable String userId) {
		return userService.getUserByUserId(userId);
	}


}
