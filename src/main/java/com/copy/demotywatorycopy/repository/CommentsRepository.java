package com.copy.demotywatorycopy.repository;

import com.copy.demotywatorycopy.repository.dao.CommentEntity;
import com.copy.demotywatorycopy.repository.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentsRepository extends JpaRepository<CommentEntity, Long> {

    Optional<CommentEntity> findByIdAndUser(Long id, UserEntity userEntity);

}
