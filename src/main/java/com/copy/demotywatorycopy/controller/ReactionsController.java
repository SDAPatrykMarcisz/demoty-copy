package com.copy.demotywatorycopy.controller;

import com.copy.demotywatorycopy.model.votes.GetReactionsResponse;
import com.copy.demotywatorycopy.model.votes.VoteType;
import com.copy.demotywatorycopy.service.votes.GetVotesService;
import com.copy.demotywatorycopy.service.votes.VotesService;
import com.copy.demotywatorycopy.validation.VoteValidType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Validated
@Transactional
public class ReactionsController {

    private final VotesService votesService;
    private final GetVotesService getVotesService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/posts/{postId}/reactions/{voteType}")
    public void vote(@PathVariable("postId")Long postId, @Valid @VoteValidType @PathVariable("voteType") String voteType){
        votesService.vote(postId, VoteType.fromCustomString(voteType));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/posts/{postId}/reactions")
    public GetReactionsResponse getReactions(@PathVariable("postId") Long postId){
        return getVotesService.getVotesForPost(postId);
    }

}
