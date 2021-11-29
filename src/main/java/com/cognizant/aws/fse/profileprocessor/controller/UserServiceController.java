package com.cognizant.aws.fse.profileprocessor.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@RequestMapping("/internal/skill-tracker/api/v1/engineer")
public class UserServiceController {

	@Autowired
	UserService userService;

	Logger logger = LogManager.getLogger(UserServiceController.class);


	@PostMapping(path="/save-profile",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveUser(@RequestBody UserJsonModel usermodel) {
		logger.info("Service saveUser - start :"+usermodel.getAssociateName());
		String status = "{ status : success}";
		try {
			userService.saveUser(usermodel);
			logger.info("Service saveUser - end :"+usermodel.getAssociateName());
		} catch (Exception e) {
			logger.info("Service saveUser - failed :"+usermodel.getAssociateName());
			status = e.getMessage();
			logger.error(status);
		}
		return status;

	}
	
	@PostMapping(path="/update-profile",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateUser(@RequestBody User user) {
		logger.info("Service updateUser - start :"+user.getAssociateName());
		String status = "{ status : success}";
		try {
			userService.updateUser(user);
			logger.info("Service updateUser - end :"+user.getAssociateName());
		} catch (Exception e) {
			logger.info("Service updateUser - failed :"+user.getAssociateName());
			status = e.getMessage();
			logger.error(status);
		}
		return status;

	}
	
	@GetMapping(value="/users/{userId}")
	public User getUserByUserId(@PathVariable String userId) {
		logger.info("Service getUserByUserId - start :"+userId);
		return userService.getUserByUserId(userId);
		
	}


}
