package com.furkan.mapstruct.service;

import com.furkan.mapstruct.dto.UserRequest;
import com.furkan.mapstruct.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse save(UserRequest userRequest);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);


}
