package com.copy.demotywatorycopy.controller;

import com.copy.demotywatorycopy.model.users.CreateUserResponse;
import com.copy.demotywatorycopy.model.users.CreateUserRequest;
import com.copy.demotywatorycopy.service.users.CreateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
public class UserController {

    private final CreateUserService createUserService;

    @PostMapping(path = "/api/users")
    public CreateUserResponse registerUser(@Valid @RequestBody CreateUserRequest registerRequest) {
        return createUserService.saveUser(registerRequest);
    }

}
