package com.copy.demotywatorycopy.repository;

import com.copy.demotywatorycopy.repository.dao.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<CommentEntity, Long> {
}
