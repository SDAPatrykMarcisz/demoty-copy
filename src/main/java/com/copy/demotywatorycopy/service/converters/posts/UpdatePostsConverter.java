package com.copy.demotywatorycopy.service.converters.posts;

import com.copy.demotywatorycopy.model.posts.UpdatePostResponse;
import com.copy.demotywatorycopy.repository.dao.PostEntity;
import com.copy.demotywatorycopy.service.converters.Convertable;
import org.springframework.stereotype.Service;

@Service
public class UpdatePostsConverter implements Convertable<Void, PostEntity, UpdatePostResponse> {

    @Override
    public PostEntity fromDto(Void input) {
        throw new UnsupportedOperationException();
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
