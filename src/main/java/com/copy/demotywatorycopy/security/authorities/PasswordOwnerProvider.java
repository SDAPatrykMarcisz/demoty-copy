package com.copy.demotywatorycopy.security.authorities;

import com.copy.demotywatorycopy.repository.UsersRepository;
import com.copy.demotywatorycopy.repository.dao.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PasswordOwnerProvider implements AuthorityProvider {

    @Override
    public boolean canHandle(HttpServletRequest request) {
        AntPathMatcher matcher = new AntPathMatcher();
        return matcher.match("/api/users/password/*", request.getRequestURI());
    }

    @Override
    public List<String> getAdditionalAuthorities(HttpServletRequest request, UserEntity userEntity) {
        Optional<Long> id = Optional.ofNullable(request.getRequestURI())
                .map(uri -> uri.replaceAll("/api/users/password/(.*)", "$1"))
                .map(Long::valueOf);

        if(id.isPresent() && userEntity.getId().equals(id.get())){
            return Collections.singletonList("PASSWORD_OWNER");
        }

        return Collections.emptyList();
    }
}
