package com.copy.demotywatorycopy.security.authorities;

import com.copy.demotywatorycopy.repository.CommentsRepository;
import com.copy.demotywatorycopy.repository.dao.CommentEntity;
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
public class CommentOwnerProvider implements AuthorityProvider {

    private final CommentsRepository commentsRepository;

    @Override
    public boolean canHandle(HttpServletRequest request) {
        AntPathMatcher matcher = new AntPathMatcher();
        return matcher.match("/api/comments/*", request.getRequestURI());
    }

    @Override
    public List<String> getAdditionalAuthorities(HttpServletRequest request, UserEntity userEntity) {
        Optional<CommentEntity> comment = Optional.ofNullable(request.getRequestURI())
                .map(uri -> uri.replaceAll("/api/comments/([1-9]+)", "$1"))
                .filter(str -> !str.isBlank())
                .map(Long::valueOf)
                .map(id -> commentsRepository.findByIdAndUser(id, userEntity))
                .filter(Optional::isPresent)
                .map(Optional::get);

        if(comment.isPresent()){
            return Collections.singletonList("COMMENT_OWNER");
        }

        return Collections.emptyList();
    }
}
