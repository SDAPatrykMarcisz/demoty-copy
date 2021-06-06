package com.copy.demotywatorycopy.view.controller;

import com.copy.demotywatorycopy.repository.PostsRepository;
import com.copy.demotywatorycopy.service.posts.GetPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ViewPostsController {

    private final GetPostService postService;

    @GetMapping("/posts")
    public String getAllDemotsPage(Model model) {
        model.addAttribute("posts", postService.getAll().getPosts());
        return "posts";
    }

}
