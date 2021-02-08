package com.copy.demotywatorycopy.controller;

import com.copy.demotywatorycopy.model.votes.VoteType;
import com.copy.demotywatorycopy.service.votes.VotesService;
import com.copy.demotywatorycopy.validation.VoteValidType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Transactional
public class ReactionsController {

    private final VotesService votesService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/posts/{postId}/reactions/{voteType:voteUp|voteDown}")
    public void vote(@PathVariable("postId")Long postId, @VoteValidType @PathVariable("voteType") String voteType){
        votesService.vote(postId, VoteType.fromCustomString(voteType));
    }

}
