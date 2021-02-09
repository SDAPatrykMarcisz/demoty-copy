package com.copy.demotywatorycopy.service.users;

import com.copy.demotywatorycopy.model.users.GetAllUsersResponse;
import com.copy.demotywatorycopy.repository.UsersRepository;
import com.copy.demotywatorycopy.service.converters.GetUsersConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetUsersService {

    private final UsersRepository usersRepository;
    private final GetUsersConverter getUsersConverter;

    public GetAllUsersResponse getAll() {
        return GetAllUsersResponse.builder()
                .users(usersRepository.findAll().stream()
                        .map(getUsersConverter::toDto)
                        .collect(Collectors.toList()))
                .build();
    }

}
