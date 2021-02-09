package com.copy.demotywatorycopy.repository;

import com.copy.demotywatorycopy.repository.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String userName);
}
