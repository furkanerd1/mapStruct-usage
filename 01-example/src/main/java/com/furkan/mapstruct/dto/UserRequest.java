package com.furkan.mapstruct.dto;

public record UserRequest (
    String firstName,
    String lastName,
    String email
){ }
