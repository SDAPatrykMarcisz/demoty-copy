package com.copy.demotywatorycopy.repository;

import com.copy.demotywatorycopy.repository.dao.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<PostEntity, Long> {
}
