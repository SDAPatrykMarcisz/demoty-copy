package com.copy.demotywatorycopy.security.authorities;

import com.copy.demotywatorycopy.repository.dao.UserEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AuthorityProvider {

    boolean canHandle(HttpServletRequest request);

    List<String> getAdditionalAuthorities(HttpServletRequest request, UserEntity userEntity);

}
