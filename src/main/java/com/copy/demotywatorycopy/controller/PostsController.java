package com.copy.demotywatorycopy.controller;

import com.copy.demotywatorycopy.model.posts.CreatePostRequest;
import com.copy.demotywatorycopy.model.posts.CreatePostResponse;
import com.copy.demotywatorycopy.model.posts.GetAllPostResponse;
import com.copy.demotywatorycopy.model.posts.GetPostResponse;
import com.copy.demotywatorycopy.service.CreatePostService;
import com.copy.demotywatorycopy.service.GetPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class PostsController {

    private final CreatePostService createPostService;
    private final GetPostService getPostService;

    @PostMapping(path = "/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePostResponse createPost(@Valid @RequestBody CreatePostRequest request){
        return createPostService.createPost(request);
    }

    @GetMapping(path = "/posts/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public GetPostResponse getPostById(@PathVariable(name = "postId") Long postId){
        return getPostService.getById(postId);
    }

    @GetMapping(path = "/posts")
    @ResponseStatus(HttpStatus.OK)
    public GetAllPostResponse getAllPost(){
        return getPostService.getAll();
    }
}
