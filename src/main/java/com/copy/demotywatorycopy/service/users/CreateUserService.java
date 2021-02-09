package com.copy.demotywatorycopy.service.users;

import com.copy.demotywatorycopy.model.users.CreateUserResponse;
import com.copy.demotywatorycopy.model.users.CreateUserRequest;
import com.copy.demotywatorycopy.repository.dao.UserEntity;
import com.copy.demotywatorycopy.repository.UsersRepository;
import com.copy.demotywatorycopy.service.converters.users.CreateUserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final UsersRepository usersRepository;
    private final CreateUserConverter createUserConverter;

    public CreateUserResponse saveUser(CreateUserRequest registerRequest) {
        UserEntity savedEntity = usersRepository.save(createUserConverter.fromDto(registerRequest));
        return createUserConverter.toDto(savedEntity);
    }

}

