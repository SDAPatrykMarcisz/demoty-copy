package com.copy.demotywatorycopy.controller;

import com.copy.demotywatorycopy.model.users.CreateUserResponse;
import com.copy.demotywatorycopy.model.users.CreateUserRequest;
import com.copy.demotywatorycopy.model.users.GetAllUsersResponse;
import com.copy.demotywatorycopy.service.users.CreateUserService;
import com.copy.demotywatorycopy.service.users.GetUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(path = "/api/users")
public class UserController {

    private final CreateUserService createUserService;
    private final GetUsersService getUsersService;

    @PostMapping
    public CreateUserResponse registerUser(@Valid @RequestBody CreateUserRequest registerRequest) {
        return createUserService.saveUser(registerRequest);
    }

    @GetMapping
    public GetAllUsersResponse getRegisteredUsers(){
        return getUsersService.getAll();
    }

}
