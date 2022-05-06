package com.example.library.service.business;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.library.dto.UpdateUserRequest;
import com.example.library.dto.UserRequest;
import com.example.library.dto.UserResponse;
import com.example.library.entity.User;
import com.example.library.repository.UserRepository;
import com.example.library.service.IUserService;

@Service
public class UserService implements IUserService{
	
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	
	
	public UserService(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public UserResponse findUserByIdentity(String identity) {
		var result = modelMapper.map(
	 			userRepository.findById(identity).get(),
	 			UserResponse.class
	 	);
		
		return result;
	}

	@Override
	public void deleteUserByIdentity(String identity) {
	 		userRepository.deleteById(identity);
	}

	
	@Override
	public UserResponse addUser(UserRequest userRequest) {
		var adduser =  modelMapper.map(userRequest, User.class);
		var result = modelMapper.map(userRepository.save(adduser), UserResponse.class);
		return result;
	}
	

	@Override
	@Transactional
	public UserResponse updateUser(String identity, UpdateUserRequest request) {
		var updateUser = userRepository.findById(identity).orElseThrow();
		
		modelMapper.map(request, updateUser);

		return modelMapper.map(updateUser, UserResponse.class);
				
	}


}
