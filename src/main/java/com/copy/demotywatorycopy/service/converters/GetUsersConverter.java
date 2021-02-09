package com.copy.demotywatorycopy.service.converters;


import com.copy.demotywatorycopy.model.users.UserInfoResponse;
import com.copy.demotywatorycopy.repository.dao.AuthorityEntity;
import com.copy.demotywatorycopy.repository.dao.UserEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class GetUsersConverter implements Convertable<Void, UserEntity, UserInfoResponse> {

    @Override
    public UserEntity fromDto(Void input) {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserInfoResponse toDto(UserEntity userEntity) {
        return UserInfoResponse.builder()
                .username(userEntity.getUsername())
                .mail(userEntity.getMail())
                .roles(userEntity.getAuthorities().stream().map(AuthorityEntity::getAuthority).collect(Collectors.toList()))
                .build();
    }
}
