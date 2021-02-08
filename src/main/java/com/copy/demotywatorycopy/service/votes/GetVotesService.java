package com.copy.demotywatorycopy.service.votes;

import com.copy.demotywatorycopy.model.votes.GetReactionsResponse;
import com.copy.demotywatorycopy.model.votes.VoteType;
import com.copy.demotywatorycopy.repository.PostsRepository;
import com.copy.demotywatorycopy.repository.VotesRepository;
import com.copy.demotywatorycopy.repository.dao.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetVotesService {

    private final VotesRepository votesRepository;
    private final PostsRepository postsRepository;

    public GetReactionsResponse getVotesForPost(Long postId) {
        PostEntity post = postsRepository.findById(postId).orElseThrow(RuntimeException::new);

        long votesUp = votesRepository.countAllByPostAndVoteTypeEquals(post, VoteType.VOTE_UP);
        long votesDown = votesRepository.countAllByPostAndVoteTypeEquals(post, VoteType.VOTE_DOWN);
        long balance = votesUp - votesDown;

        return GetReactionsResponse.builder()
                .votesUp(votesUp)
                .votesDown(votesDown)
                .balance(balance)
                .build();
    }
}
