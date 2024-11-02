package com.furkan.mapstruct.service;

import com.furkan.mapstruct.dto.UserRequest;
import com.furkan.mapstruct.dto.UserResponse;
import com.furkan.mapstruct.entity.User;
import com.furkan.mapstruct.mapper.UserMapper;
import com.furkan.mapstruct.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    @Transactional
    public UserResponse save(UserRequest userRequest) {
        User user = userMapper.toEntity(userRequest);
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    @Override
    public List<UserResponse> getAllUsers() {
          List<User> users = userRepository.findAll();
          return userMapper.toResponseList(users);
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return userMapper.toResponse(user);
    }
}
