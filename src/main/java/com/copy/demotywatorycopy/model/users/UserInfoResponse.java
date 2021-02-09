package com.copy.demotywatorycopy.model.users;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class UserInfoResponse {
    private String username;
    private String mail;
    private boolean active;
    private List<String> roles;
}
