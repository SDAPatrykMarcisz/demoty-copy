package com.copy.demotywatorycopy.repository;

import com.copy.demotywatorycopy.repository.dao.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotesRepository extends JpaRepository<VoteEntity, Long> {
}
