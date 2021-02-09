package com.copy.demotywatorycopy.model.users;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class GetAllUsersResponse {
    private List<UserInfoResponse> users;
}
