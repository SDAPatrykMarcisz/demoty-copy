package com.copy.demotywatorycopy.service;

import com.copy.demotywatorycopy.model.posts.GetAllPostResponse;
import com.copy.demotywatorycopy.model.posts.GetPostResponse;
import com.copy.demotywatorycopy.repository.PostsRepository;
import com.copy.demotywatorycopy.repository.dao.PostEntity;
import com.copy.demotywatorycopy.service.converters.GetPostConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetPostService {

    private final PostsRepository postsRepository;
    private final GetPostConverter getPostConverter;

    public GetPostResponse getById(Long postId) {
        PostEntity postEntity = postsRepository.findById(postId).orElseThrow(RuntimeException::new);
        return getPostConverter.toDto(postEntity);
    }

    public GetAllPostResponse getAll() {
        return GetAllPostResponse.builder()
                .posts(postsRepository.findAll().stream()
                .map(getPostConverter::toDto)
                .collect(Collectors.toList()))
                .build();
    }
}
