package com.copy.demotywatorycopy.controller;

import com.copy.demotywatorycopy.model.posts.*;
import com.copy.demotywatorycopy.service.posts.CreatePostService;
import com.copy.demotywatorycopy.service.posts.DeletePostService;
import com.copy.demotywatorycopy.service.posts.GetPostService;
import com.copy.demotywatorycopy.service.posts.UpdatePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
@Transactional
public class PostsController {

    private final CreatePostService createPostService;
    private final GetPostService getPostService;
    private final UpdatePostService updatePostService;
    private final DeletePostService deletePostService;

    @PostMapping(path = "/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePostResponse createPost(@Valid @RequestBody CreatePostRequest request) {
        return createPostService.createPost(request);
    }

    @GetMapping(path = "/posts/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public GetPostResponse getPostById(@PathVariable(name = "postId") Long postId) {
        return getPostService.getById(postId);
    }

    @GetMapping(path = "/posts")
    @ResponseStatus(HttpStatus.OK)
    public GetAllPostResponse getAllPost() {
        return getPostService.getAll();
    }

    @PutMapping(path = "/posts/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public UpdatePostResponse updatePost(@Valid @RequestBody UpdatePostRequest request, @PathVariable(name = "postId") Long postId) {
        return updatePostService.update(request, postId);
    }

    @DeleteMapping(path = "/posts/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable(name = "postId") Long postId) {
        deletePostService.delete(postId);
    }

}
