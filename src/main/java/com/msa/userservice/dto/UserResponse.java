package com.msa.userservice.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String email;
    private String name;

    private UserResponse(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public static UserResponse of(UserDto user) {
        return new UserResponse(user.getUserId(), user.getEmail(), user.getName());
    }
}
