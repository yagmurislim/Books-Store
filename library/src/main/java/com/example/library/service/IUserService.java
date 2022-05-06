package com.example.library.service;

import com.example.library.dto.UpdateUserRequest;
import com.example.library.dto.UserRequest;
import com.example.library.dto.UserResponse;

public interface IUserService {

	UserResponse findUserByIdentity(String identity);

	void deleteUserByIdentity(String identity);

	UserResponse addUser(UserRequest user);

	UserResponse updateUser(String identity, UpdateUserRequest user);

}
