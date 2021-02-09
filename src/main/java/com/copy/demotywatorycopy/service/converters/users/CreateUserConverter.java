package com.copy.demotywatorycopy.service.converters.users;

import com.copy.demotywatorycopy.model.users.CreateUserResponse;
import com.copy.demotywatorycopy.model.users.CreateUserRequest;
import com.copy.demotywatorycopy.repository.dao.AuthorityEntity;
import com.copy.demotywatorycopy.repository.AuthoritiesRepository;
import com.copy.demotywatorycopy.repository.dao.UserEntity;
import com.copy.demotywatorycopy.service.converters.Convertable;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreateUserConverter implements Convertable<CreateUserRequest, UserEntity, CreateUserResponse> {

    private final PasswordEncoder passwordEncoder;
    private final AuthoritiesRepository authoritiesRepository;

    @Override
    public UserEntity fromDto(CreateUserRequest registerRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(registerRequest.getUsername());
        userEntity.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userEntity.setActive(registerRequest.isActive());
        List<AuthorityEntity> authorities = Optional.ofNullable(registerRequest.getRoles()).map(roles -> roles.stream()
                .map(str -> authoritiesRepository.findByAuthority("ROLE_" + str).orElseThrow(RuntimeException::new))
                .collect(Collectors.toList())
        ).orElse(Collections.singletonList(authoritiesRepository.findByAuthority("ROLE_USER").orElseThrow(RuntimeException::new)));
        userEntity.setAuthorities(authorities);
        return userEntity;
    }

    @Override
    public CreateUserResponse toDto(UserEntity userEntity) {
        return CreateUserResponse.builder()
                .username(userEntity.getUsername())
                .mail(userEntity.getMail())
                .roles(userEntity.getAuthorities().stream()
                        .map(AuthorityEntity::getAuthority)
                        .collect(Collectors.toList()))
                .build();
    }
}
