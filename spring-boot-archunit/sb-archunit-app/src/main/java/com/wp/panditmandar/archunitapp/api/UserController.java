package com.wp.panditmandar.archunitapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wp.panditmandar.archunitapp.service.UserService;

@RestController("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
		UserResponse userResponse = userService.createPublisher(userRequest);
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
	}

}
