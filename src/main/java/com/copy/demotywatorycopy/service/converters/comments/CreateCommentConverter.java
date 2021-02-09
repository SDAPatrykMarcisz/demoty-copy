package com.copy.demotywatorycopy.service.converters.comments;

import com.copy.demotywatorycopy.model.comments.CreateCommentRequest;
import com.copy.demotywatorycopy.model.comments.CreateCommentResponse;
import com.copy.demotywatorycopy.repository.dao.CommentEntity;
import com.copy.demotywatorycopy.service.converters.Convertable;
import org.springframework.stereotype.Service;

@Service
public class CreateCommentConverter implements Convertable<CreateCommentRequest, CommentEntity, CreateCommentResponse> {

    @Override
    public CommentEntity fromDto(CreateCommentRequest input) {
        CommentEntity entity = new CommentEntity();
        entity.setContent(input.getContent());
        return entity;
    }

    @Override
    public CreateCommentResponse toDto(CommentEntity commentEntity) {
        return CreateCommentResponse.builder()
                .id(commentEntity.getId())
                .content(commentEntity.getContent())
                .build();
    }
}
