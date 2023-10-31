package com.wp.panditmandar.archunitapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.panditmandar.archunitapp.api.UserRequest;
import com.wp.panditmandar.archunitapp.api.UserResponse;
import com.wp.panditmandar.archunitapp.data.User;
import com.wp.panditmandar.archunitapp.data.UserData;

@Service
public class UserService {
	
	@Autowired
	private UserData userData;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UserResponse createPublisher(UserRequest requestDTO) {
		User user = modelMapper.map(requestDTO, User.class);
		userData.save(user);
		return modelMapper.map(user, UserResponse.class);
	}

}
