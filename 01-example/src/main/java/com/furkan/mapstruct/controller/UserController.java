package com.furkan.mapstruct.controller;

import com.furkan.mapstruct.dto.UserRequest;
import com.furkan.mapstruct.dto.UserResponse;
import com.furkan.mapstruct.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

   @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
       return ResponseEntity.ok(userService.save(userRequest));
   }

   @GetMapping()
    public ResponseEntity<List<UserResponse>> getAllUsers() {
       return ResponseEntity.ok(userService.getAllUsers());
   }

   @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
       return ResponseEntity.ok(userService.getUserById(id));
   }

}
