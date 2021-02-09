package com.copy.demotywatorycopy.service.users;

import com.copy.demotywatorycopy.model.users.ChangePasswordRequest;
import com.copy.demotywatorycopy.repository.UsersRepository;
import com.copy.demotywatorycopy.repository.dao.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangePasswordService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public void changePasswordForUser(Long userId, ChangePasswordRequest request){
        UserEntity userEntity = usersRepository.findById(userId).orElseThrow(RuntimeException::new);
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
    }

}
