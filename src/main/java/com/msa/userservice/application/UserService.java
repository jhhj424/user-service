package com.msa.userservice.application;

import com.msa.userservice.dto.UserDto;

public interface UserService {
    UserDto create(UserDto userDto);
}
