package com.copy.demotywatorycopy.security.authorities;

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
public class AccountOwnerProvider implements AuthorityProvider {

    @Override
    public boolean canHandle(HttpServletRequest request) {
        AntPathMatcher matcher = new AntPathMatcher();
        return matcher.match("/api/users/*", request.getRequestURI()) && "DELETE".equals(request.getMethod());
    }

    @Override
    public List<String> getAdditionalAuthorities(HttpServletRequest request, UserEntity userEntity) {
        Optional<Long> id = Optional.ofNullable(request.getRequestURI())
                .map(uri -> uri.replaceAll("/api/users/([1-9]+)", "$1"))
                .filter(str -> !str.isBlank())
                .map(Long::valueOf);

        if(id.isPresent() && userEntity.getId().equals(id.get())){
            return Collections.singletonList("ACCOUNT_OWNER");
        }

        return Collections.emptyList();
    }
}
