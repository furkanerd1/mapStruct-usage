package com.furkan.mapstruct.mapper;

import com.furkan.mapstruct.dto.UserRequest;
import com.furkan.mapstruct.dto.UserResponse;
import com.furkan.mapstruct.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", imports = LocalDateTime.class)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    User toEntity(UserRequest userRequest);

    UserResponse toResponse(User user);

    List<UserResponse> toResponseList(List<User> users);




}
