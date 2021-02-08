package com.copy.demotywatorycopy.service.votes;

import com.copy.demotywatorycopy.model.votes.VoteType;
import com.copy.demotywatorycopy.repository.PostsRepository;
import com.copy.demotywatorycopy.repository.VotesRepository;
import com.copy.demotywatorycopy.repository.dao.PostEntity;
import com.copy.demotywatorycopy.repository.dao.VoteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VotesService {

    private final PostsRepository postsRepository;
    private final VotesRepository votesRepository;

    public void vote(Long postId, VoteType voteType) {
        PostEntity post = postsRepository.findById(postId).orElseThrow(RuntimeException::new);
        VoteEntity newVote = new VoteEntity();
        newVote.setPost(post);
        newVote.setVoteType(voteType);
        VoteEntity savedVote = votesRepository.save(newVote);
        post.getVotes().add(savedVote);
    }
}
