package com.copy.demotywatorycopy.security.authorities;

import com.copy.demotywatorycopy.repository.PostsRepository;
import com.copy.demotywatorycopy.repository.dao.PostEntity;
import com.copy.demotywatorycopy.repository.dao.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostOwnerProvider implements AuthorityProvider {

    private final PostsRepository postsRepository;

    @Override
    public boolean canHandle(HttpServletRequest request) {
        AntPathMatcher matcher = new AntPathMatcher();
        return matcher.match("/api/posts/*", request.getRequestURI()) && !"GET".equals(request.getMethod());
    }

    @Override
    public List<String> getAdditionalAuthorities(HttpServletRequest request, UserEntity userEntity) {
        Optional<PostEntity> post = Optional.ofNullable(request.getRequestURI())
                .map(uri -> uri.replaceAll("/api/posts/([1-9]+)", "$1"))
                .filter(str -> !str.isBlank())
                .filter(str -> str.matches("[1-9]+"))
                .map(Long::valueOf)
                .map(id -> postsRepository.findByIdAndUser(id, userEntity))
                .filter(Optional::isPresent)
                .map(Optional::get);

        if(post.isPresent() && userEntity.getId().equals(post.get().getId())){
            return Collections.singletonList("POST_OWNER");
        }

        return Collections.emptyList();
    }
}
