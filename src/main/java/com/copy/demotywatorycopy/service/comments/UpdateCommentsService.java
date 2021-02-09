package com.copy.demotywatorycopy.service.comments;

import com.copy.demotywatorycopy.model.comments.UpdateCommentRequest;
import com.copy.demotywatorycopy.model.comments.UpdateCommentResponse;
import com.copy.demotywatorycopy.repository.CommentsRepository;
import com.copy.demotywatorycopy.repository.dao.CommentEntity;
import com.copy.demotywatorycopy.service.converters.UpdateCommentsConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCommentsService {

    private final UpdateCommentsConverter updateCommentsConverter;
    private final CommentsRepository commentsRepository;

    public UpdateCommentResponse update(Long commentId, UpdateCommentRequest request) {
        CommentEntity commentEntity = commentsRepository.findById(commentId).orElseThrow(RuntimeException::new);
        commentEntity.setContent(request.getContent());
        return updateCommentsConverter.toDto(commentEntity);
    }
}
