package com.copy.demotywatorycopy.service;

import com.copy.demotywatorycopy.repository.UsersRepository;
import com.copy.demotywatorycopy.repository.dao.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserService {

    private final UsersRepository usersRepository;

    public void deleteAccount(Long userId) {
        UserEntity userEntity = usersRepository.findById(userId).orElseThrow(RuntimeException::new);
        userEntity.setActive(false);
        userEntity.setUsername(null);
        userEntity.setAuthorities(null);
        userEntity.setPassword(null);
        userEntity.setMail(null);
    }
}
