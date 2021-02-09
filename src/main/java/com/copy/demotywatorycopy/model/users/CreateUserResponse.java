package com.copy.demotywatorycopy.model.users;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CreateUserResponse {

    private String username;
    private String mail;
    private List<String> roles;

}
