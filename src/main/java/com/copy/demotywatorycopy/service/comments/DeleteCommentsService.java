package com.copy.demotywatorycopy.service.comments;

import com.copy.demotywatorycopy.repository.CommentsRepository;
import com.copy.demotywatorycopy.repository.dao.CommentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCommentsService {

    private final CommentsRepository commentsRepository;

    public void delete(Long id) {
        CommentEntity toDelete = commentsRepository.findById(id).orElseThrow(RuntimeException::new);
        commentsRepository.delete(toDelete);
    }
}
