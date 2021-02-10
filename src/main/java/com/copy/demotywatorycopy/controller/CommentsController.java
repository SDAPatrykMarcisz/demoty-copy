package com.copy.demotywatorycopy.controller;

import com.copy.demotywatorycopy.model.comments.UpdateCommentRequest;
import com.copy.demotywatorycopy.model.comments.UpdateCommentResponse;
import com.copy.demotywatorycopy.model.comments.CreateCommentRequest;
import com.copy.demotywatorycopy.model.comments.CreateCommentResponse;
import com.copy.demotywatorycopy.model.comments.GetAllCommentsResponse;
import com.copy.demotywatorycopy.model.comments.GetCommentResponse;
import com.copy.demotywatorycopy.security.annotations.CommentOwnerOrAdmin;
import com.copy.demotywatorycopy.security.annotations.IsLoggedUser;
import com.copy.demotywatorycopy.service.comments.DeleteCommentsService;
import com.copy.demotywatorycopy.service.comments.GetCommentsService;
import com.copy.demotywatorycopy.service.comments.UpdateCommentsService;
import com.copy.demotywatorycopy.service.comments.CreateCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Transactional
public class CommentsController {

    private final CreateCommentService commentService;
    private final GetCommentsService getCommentService;
    private final UpdateCommentsService updateCommentService;
    private final DeleteCommentsService deleteCommentService;

    @IsLoggedUser
    @PostMapping("/posts/{postId}/comments")
    public CreateCommentResponse addComment(@Valid @RequestBody CreateCommentRequest request, @PathVariable(name = "postId") Long id, Principal principal){
        return commentService.addComment(id, request, principal);
    }

    @GetMapping("/posts/{postId}/comments")
    public GetAllCommentsResponse getAllComments(@PathVariable(name = "postId")Long postId){
        return getCommentService.getAll(postId);
    }

    @GetMapping("/comments/{commentId}")
    public GetCommentResponse getCommentById(@PathVariable(name = "commentId") Long commentId){
        return getCommentService.getById(commentId);
    }

    @CommentOwnerOrAdmin
    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable(name = "commentId") Long commentId){
        deleteCommentService.delete(commentId);
    }

    @CommentOwnerOrAdmin
    @PutMapping("/comments/{commentId}")
    public UpdateCommentResponse updateComment(@PathVariable(name = "commentId") Long commentId, @RequestBody UpdateCommentRequest request){
        return updateCommentService.update(commentId, request);
    }

}
