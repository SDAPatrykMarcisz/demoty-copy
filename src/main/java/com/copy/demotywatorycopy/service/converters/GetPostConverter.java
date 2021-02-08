package com.copy.demotywatorycopy.service.converters;

import com.copy.demotywatorycopy.model.posts.GetPostResponse;
import com.copy.demotywatorycopy.repository.dao.PostEntity;
import com.copy.demotywatorycopy.service.converters.Convertable;
import org.springframework.stereotype.Service;

@Service
public class GetPostConverter implements Convertable<Void, PostEntity, GetPostResponse> {

    @Override
    public PostEntity fromDto(Void input) {
        throw new UnsupportedOperationException("invalid operation for this call");
    }

    @Override
    public GetPostResponse toDto(PostEntity postEntity) {
        return GetPostResponse.builder()
                .id(postEntity.getId())
                .topText(postEntity.getTopText())
                .bottomText(postEntity.getBottomText())
                .imagePath(postEntity.getImagePath())
                .build();
    }
}
