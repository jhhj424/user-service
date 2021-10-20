package com.msa.userservice.dto;

import com.msa.userservice.domain.User;
import lombok.Data;


@Data
public class UserDto {
    private Long userId;
    private String email;
    private String password;
    private String name;

    private UserDto(Long userId, String email, String password, String name) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    private UserDto(String email, String password, String name) {
        this(null, email, password, name);
    }

    public static UserDto of(UserRequest userRequest) {
        return new UserDto(userRequest.getEmail(), userRequest.getPassword(), userRequest.getName());
    }

    public static UserDto of(User user) {
        return new UserDto(user.getId(), user.getEmail(), user.getPassword(), user.getName());
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .name(name)
                .build();
    }
}
