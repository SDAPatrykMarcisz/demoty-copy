package com.copy.demotywatorycopy.service.posts;

import com.copy.demotywatorycopy.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePostService {

    private final PostsRepository postsRepository;

    public void delete(Long postId) {
        postsRepository.delete(postsRepository.findById(postId).orElseThrow(RuntimeException::new));
    }
}
