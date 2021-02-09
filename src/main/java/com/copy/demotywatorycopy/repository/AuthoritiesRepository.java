package com.copy.demotywatorycopy.repository;

import com.copy.demotywatorycopy.repository.dao.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthoritiesRepository extends JpaRepository<AuthorityEntity, Long> {
    Optional<AuthorityEntity> findByAuthority(String authorityName);
}
