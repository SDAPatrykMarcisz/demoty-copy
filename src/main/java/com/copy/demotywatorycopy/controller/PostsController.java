package com.copy.demotywatorycopy.controller;

import com.copy.demotywatorycopy.model.posts.CreatePostRequest;
import com.copy.demotywatorycopy.model.posts.CreatePostResponse;
import com.copy.demotywatorycopy.service.CreatePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class PostsController {

    private final CreatePostService createPostService;

    @PostMapping(path = "/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePostResponse createPost(@Valid @RequestBody CreatePostRequest request){
        return createPostService.createPost(request);
    }

}
