package com.copy.demotywatorycopy.repository;

import com.copy.demotywatorycopy.model.votes.VoteType;
import com.copy.demotywatorycopy.repository.dao.PostEntity;
import com.copy.demotywatorycopy.repository.dao.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotesRepository extends JpaRepository<VoteEntity, Long> {
    long countAllByPostAndVoteTypeEquals(PostEntity post, VoteType voteType);
}
