package com.copy.demotywatorycopy.controller;

import com.copy.demotywatorycopy.model.users.ChangePasswordRequest;
import com.copy.demotywatorycopy.model.users.CreateUserRequest;
import com.copy.demotywatorycopy.model.users.CreateUserResponse;
import com.copy.demotywatorycopy.model.users.GetAllUsersResponse;
import com.copy.demotywatorycopy.security.annotations.AccountOwnerOrAdmin;
import com.copy.demotywatorycopy.security.annotations.AllowedForAdmin;
import com.copy.demotywatorycopy.security.annotations.PasswordOwnerOrAdmin;
import com.copy.demotywatorycopy.service.ActivateUserService;
import com.copy.demotywatorycopy.service.DeleteUserService;
import com.copy.demotywatorycopy.service.users.ChangePasswordService;
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
    private final ChangePasswordService changePasswordService;
    private final DeleteUserService deleteUserService;

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
    @PutMapping("{userId}/activate/")
    public void activateUser(@PathVariable(name = "userId") Long id) {
        activateUserService.byId(id);
    }

    @PasswordOwnerOrAdmin
    @PutMapping("/{userId}/password")
    public void changePassword(@PathVariable(name = "userId") Long userId, @RequestBody ChangePasswordRequest request){
        changePasswordService.changePasswordForUser(userId, request);
    }

    @AccountOwnerOrAdmin
    @DeleteMapping("/{userId}")
    public void deleteAccount(@PathVariable(name = "userId") Long userId){
        deleteUserService.deleteAccount(userId);
    }

}
