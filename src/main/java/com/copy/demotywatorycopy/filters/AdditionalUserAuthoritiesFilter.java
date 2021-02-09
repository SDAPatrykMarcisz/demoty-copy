package com.copy.demotywatorycopy.filters;

import com.copy.demotywatorycopy.repository.UsersRepository;
import com.copy.demotywatorycopy.repository.dao.UserEntity;
import com.copy.demotywatorycopy.security.authorities.AuthoritiesProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class AdditionalUserAuthoritiesFilter extends GenericFilterBean {

    private final AuthoritiesProvider authoritiesProvider;
    private final UsersRepository usersRepository;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(Objects.nonNull(auth)){
            List<GrantedAuthority> updatedAuthorities = new ArrayList<>(auth.getAuthorities());
            Optional<UserEntity> byUsername = usersRepository.findByUsername(((UserDetails) auth.getPrincipal()).getUsername());
            if(byUsername.isPresent()){
                Collection<String> additionalAuthorities = authoritiesProvider.checkAdditionalAuthorities(byUsername.get());
                updatedAuthorities.addAll(additionalAuthorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())); //add your role here [e.g., new SimpleGrantedAuthority("ROLE_NEW_ROLE")]
                Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), updatedAuthorities);
                SecurityContextHolder.getContext().setAuthentication(newAuth);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
