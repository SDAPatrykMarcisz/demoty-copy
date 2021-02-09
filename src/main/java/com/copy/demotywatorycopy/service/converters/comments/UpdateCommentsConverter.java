package com.copy.demotywatorycopy.service.converters.comments;

import com.copy.demotywatorycopy.model.comments.UpdateCommentRequest;
import com.copy.demotywatorycopy.model.comments.UpdateCommentResponse;
import com.copy.demotywatorycopy.repository.dao.CommentEntity;
import com.copy.demotywatorycopy.service.converters.Convertable;
import org.springframework.stereotype.Service;

@Service
public class UpdateCommentsConverter implements Convertable<UpdateCommentRequest, CommentEntity, UpdateCommentResponse> {
    @Override
    public CommentEntity fromDto(UpdateCommentRequest input) {
        throw new UnsupportedOperationException();
    }

    @Override
    public UpdateCommentResponse toDto(CommentEntity commentEntity) {
        return UpdateCommentResponse.builder()
                .id(commentEntity.getId())
                .content(commentEntity.getContent())
                .build();
    }
}
