package com.copy.demotywatorycopy.service.comments;

import com.copy.demotywatorycopy.model.comments.GetAllCommentsResponse;
import com.copy.demotywatorycopy.model.comments.GetCommentResponse;
import com.copy.demotywatorycopy.repository.CommentsRepository;
import com.copy.demotywatorycopy.repository.PostsRepository;
import com.copy.demotywatorycopy.repository.dao.PostEntity;
import com.copy.demotywatorycopy.service.converters.comments.GetCommentConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetCommentsService {

    private final GetCommentConverter getCommentConverter;
    private final CommentsRepository commentsRepository;
    private final PostsRepository postsRepository;

    public GetCommentResponse getById(Long commentId) {
        return getCommentConverter.toDto(commentsRepository.findById(commentId).orElseThrow(RuntimeException::new));
    }

    public GetAllCommentsResponse getAll(Long postId) {
        return postsRepository.findById(postId)
                .map(PostEntity::getComments)
                .map(comments -> GetAllCommentsResponse.builder()
                        .comments(comments.stream()
                                .map(getCommentConverter::toDto)
                                .collect(Collectors.toList()))
                        .build())
                .orElseThrow(RuntimeException::new);
    }

}
