package com.copy.demotywatorycopy.service.converters.posts;

import com.copy.demotywatorycopy.model.posts.CreatePostRequest;
import com.copy.demotywatorycopy.model.posts.CreatePostResponse;
import com.copy.demotywatorycopy.repository.dao.PostEntity;
import com.copy.demotywatorycopy.service.converters.Convertable;
import org.springframework.stereotype.Service;

@Service
public class CreatePostsConverter implements Convertable<CreatePostRequest, PostEntity, CreatePostResponse> {

    @Override
    public PostEntity fromDto(CreatePostRequest input) {
        PostEntity entity = new PostEntity();
        entity.setBottomText(input.getBottomText());
        entity.setTopText(input.getTopText());
        entity.setImagePath(input.getImagePath());
        return entity;
    }

    @Override
    public CreatePostResponse toDto(PostEntity postEntity) {
        return CreatePostResponse.builder()
                .id(postEntity.getId())
                .topText(postEntity.getTopText())
                .bottomText(postEntity.getBottomText())
                .imagePath(postEntity.getImagePath())
                .build();
    }
}
