package com.msa.userservice.application;

import com.msa.userservice.dto.UserDto;
import com.msa.userservice.domain.User;
import com.msa.userservice.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public UserDto create(UserDto userDto) {
        User savedUser = userRepository.save(userDto.toEntity());
        return UserDto.of(savedUser);
    }
}
