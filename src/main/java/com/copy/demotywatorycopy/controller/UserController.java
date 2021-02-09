package com.copy.demotywatorycopy.controller;

import com.copy.demotywatorycopy.model.users.CreateUserRequest;
import com.copy.demotywatorycopy.model.users.CreateUserResponse;
import com.copy.demotywatorycopy.model.users.GetAllUsersResponse;
import com.copy.demotywatorycopy.security.annotations.AllowedForAdmin;
import com.copy.demotywatorycopy.service.ActivateUserService;
import com.copy.demotywatorycopy.service.users.CreateUserService;
import com.copy.demotywatorycopy.service.users.GetUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/users")
@Transactional
public class UserController {

    private final CreateUserService createUserService;
    private final ActivateUserService activateUserService;
    private final GetUsersService getUsersService;

    @PostMapping
    public CreateUserResponse registerUser(@Valid @RequestBody CreateUserRequest registerRequest) {
        return createUserService.saveUser(registerRequest);
    }

    @AllowedForAdmin
    @GetMapping
    public GetAllUsersResponse getRegisteredUsers() {
        return getUsersService.getAll();
    }

    @AllowedForAdmin
    @PutMapping("/activate/{userId}")
    public void activateUser(@PathVariable(name = "userId") Long id) {
        activateUserService.byId(id);
    }


}
