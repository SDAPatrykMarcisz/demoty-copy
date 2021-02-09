package com.copy.demotywatorycopy.service.converters;

import com.copy.demotywatorycopy.model.comments.GetCommentResponse;
import com.copy.demotywatorycopy.repository.dao.CommentEntity;
import org.springframework.stereotype.Service;

@Service
public class GetCommentConverter implements Convertable<Void, CommentEntity, GetCommentResponse> {

    @Override
    public CommentEntity fromDto(Void input) {
        throw new UnsupportedOperationException();
    }

    @Override
    public GetCommentResponse toDto(CommentEntity commentEntity) {
        return GetCommentResponse.builder()
                .id(commentEntity.getId())
                .content(commentEntity.getContent())
                .build();
    }
}
