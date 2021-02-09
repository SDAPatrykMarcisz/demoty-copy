package com.copy.demotywatorycopy.security.authorities;

import com.copy.demotywatorycopy.repository.dao.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthoritiesProvider {

    private final List<AuthorityProvider> authorityProviderList;
    private final HttpServletRequest request;

    public Collection<String> checkAdditionalAuthorities(UserEntity userEntity) {
        List<String> authorities = new ArrayList<>();
        for(AuthorityProvider provider : authorityProviderList){
            if(provider.canHandle(request)) {
                authorities.addAll(provider.getAdditionalAuthorities(request, userEntity));
            }
        }
        return authorities;
    }
}
