package com.copy.demotywatorycopy.controller;

import com.copy.demotywatorycopy.model.comments.CreateCommentRequest;
import com.copy.demotywatorycopy.model.comments.CreateCommentResponse;
import com.copy.demotywatorycopy.service.comments.CreateCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentsController {

    private final CreateCommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public CreateCommentResponse addComment(@Valid @RequestBody CreateCommentRequest request, @PathVariable(name = "postId") Long id){
        return commentService.addComment(id, request);
    }

}
