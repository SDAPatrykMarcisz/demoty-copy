package com.copy.demotywatorycopy.service;

import com.copy.demotywatorycopy.model.posts.UpdatePostRequest;
import com.copy.demotywatorycopy.model.posts.UpdatePostResponse;
import com.copy.demotywatorycopy.repository.PostsRepository;
import com.copy.demotywatorycopy.repository.dao.PostEntity;
import com.copy.demotywatorycopy.service.converters.UpdatePostsConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePostService {

    private final PostsRepository postsRepository;
    private final UpdatePostsConverter updatePostsConverter;

    public UpdatePostResponse update(UpdatePostRequest request, Long id) {
        PostEntity entityToUpdate = postsRepository.findById(id).orElseThrow(RuntimeException::new);
        entityToUpdate.setTopText(request.getTopText());
        entityToUpdate.setBottomText(request.getBottomText());
        entityToUpdate.setImagePath(request.getImagePath());
        return updatePostsConverter.toDto(entityToUpdate);
    }

}
