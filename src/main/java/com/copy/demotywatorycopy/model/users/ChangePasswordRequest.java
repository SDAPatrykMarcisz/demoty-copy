package com.copy.demotywatorycopy.model.users;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ChangePasswordRequest {

    @NotEmpty
    private String password;

}
