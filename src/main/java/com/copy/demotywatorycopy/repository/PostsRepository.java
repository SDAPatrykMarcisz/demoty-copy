package com.copy.demotywatorycopy.repository;

import com.copy.demotywatorycopy.repository.dao.PostEntity;
import com.copy.demotywatorycopy.repository.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostsRepository extends JpaRepository<PostEntity, Long> {

    Optional<PostEntity> findByIdAndUser(Long id, UserEntity userEntity);

}
