package com.copy.demotywatorycopy.model.users;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    @NotNull
    private String username;

    @NotNull
    @Length(min = 5, max = 40)
    private String password;

    @NotNull
    private String mail;

    private List<String> roles;

}
