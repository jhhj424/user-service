package com.msa.userservice.api;

import com.msa.userservice.application.UserService;
import com.msa.userservice.dto.UserDto;
import com.msa.userservice.dto.UserRequest;
import com.msa.userservice.dto.UserResponse;
import com.msa.userservice.env.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class UsersController {

    private final Greeting greeting;
    private final UserService userService;

    @GetMapping("/health_check")
    public String status() {
        return "It's Working in User Service";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return greeting.getMessage();
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        UserDto user = userService.create(UserDto.of(userRequest));
        return ResponseEntity.created(URI.create("/users/" + user.getUserId())).body(UserResponse.of(user));
    }
}
