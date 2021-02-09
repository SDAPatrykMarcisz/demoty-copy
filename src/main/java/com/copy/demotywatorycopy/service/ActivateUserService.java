package com.copy.demotywatorycopy.service;

import com.copy.demotywatorycopy.repository.UsersRepository;
import com.copy.demotywatorycopy.repository.dao.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivateUserService {

    private final UsersRepository usersRepository;

    public void byId(Long id) {
        UserEntity userEntity = usersRepository.findById(id).orElseThrow(RuntimeException::new);
        userEntity.setActive(true);
    }
}
