package com.copy.demotywatorycopy.service.converters.posts;

import com.copy.demotywatorycopy.model.posts.UpdatePostRequest;
import com.copy.demotywatorycopy.model.posts.UpdatePostResponse;
import com.copy.demotywatorycopy.repository.dao.PostEntity;
import com.copy.demotywatorycopy.service.converters.Convertable;
import org.springframework.stereotype.Service;

@Service
public class UpdatePostsConverter implements Convertable<UpdatePostRequest, PostEntity, UpdatePostResponse> {

    @Override
    public PostEntity fromDto(UpdatePostRequest input) {
        PostEntity entity = new PostEntity();
        entity.setBottomText(input.getBottomText());
        entity.setTopText(input.getTopText());
        entity.setImagePath(input.getImagePath());
        return entity;
    }

    @Override
    public UpdatePostResponse toDto(PostEntity postEntity) {
        return UpdatePostResponse.builder()
                .id(postEntity.getId())
                .topText(postEntity.getTopText())
                .bottomText(postEntity.getBottomText())
                .imagePath(postEntity.getImagePath())
                .build();
    }
}
