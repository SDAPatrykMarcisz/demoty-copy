package com.copy.demotywatorycopy.service.comments;

import com.copy.demotywatorycopy.model.comments.CreateCommentRequest;
import com.copy.demotywatorycopy.model.comments.CreateCommentResponse;
import com.copy.demotywatorycopy.repository.CommentsRepository;
import com.copy.demotywatorycopy.repository.PostsRepository;
import com.copy.demotywatorycopy.repository.dao.CommentEntity;
import com.copy.demotywatorycopy.repository.dao.PostEntity;
import com.copy.demotywatorycopy.service.converters.comments.CreateCommentConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCommentService {

    private final CommentsRepository commentsRepository;
    private final PostsRepository postsRepository;
    private final CreateCommentConverter createCommentConverter;

    public CreateCommentResponse addComment(Long postId, CreateCommentRequest request){
        PostEntity post = postsRepository.findById(postId).orElseThrow(RuntimeException::new);
        CommentEntity commentToSave = createCommentConverter.fromDto(request);
        commentToSave.setPost(post);
        CommentEntity savedEntity = commentsRepository.save(commentToSave);
        return createCommentConverter.toDto(savedEntity);
    }

}
