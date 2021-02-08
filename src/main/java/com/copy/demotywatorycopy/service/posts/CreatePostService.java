package com.copy.demotywatorycopy.service.posts;

import com.copy.demotywatorycopy.model.posts.CreatePostRequest;
import com.copy.demotywatorycopy.model.posts.CreatePostResponse;
import com.copy.demotywatorycopy.repository.PostsRepository;
import com.copy.demotywatorycopy.repository.dao.PostEntity;
import com.copy.demotywatorycopy.service.converters.posts.CreatePostsConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePostService {

    private final PostsRepository postsRepository;
    private final CreatePostsConverter createPostsConverter;

    public CreatePostResponse createPost(CreatePostRequest request) {
        PostEntity fromDto = createPostsConverter.fromDto(request);
        PostEntity savedEntity = postsRepository.save(fromDto);
        return createPostsConverter.toDto(savedEntity);
    }

}
