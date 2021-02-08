package com.copy.demotywatorycopy.service;

import com.copy.demotywatorycopy.model.posts.GetPostResponse;
import com.copy.demotywatorycopy.repository.PostsRepository;
import com.copy.demotywatorycopy.repository.dao.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPostService {

    private final PostsRepository postsRepository;
    private final GetPostConverter getPostConverter;

    public GetPostResponse getById(Long postId) {
        PostEntity postEntity = postsRepository.findById(postId).orElseThrow(() -> new RuntimeException());
        return getPostConverter.toDto(postEntity);
    }
}
