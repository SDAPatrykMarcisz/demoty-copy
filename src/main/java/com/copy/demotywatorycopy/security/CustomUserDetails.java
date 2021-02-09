package com.copy.demotywatorycopy.security;

import com.copy.demotywatorycopy.repository.dao.AuthorityEntity;
import com.copy.demotywatorycopy.repository.dao.UserEntity;
import com.copy.demotywatorycopy.repository.UsersRepository;
import com.copy.demotywatorycopy.security.authorities.AuthoritiesProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Primary
@Transactional
public class CustomUserDetails implements UserDetailsService {

    private final UsersRepository usersRepository;
    private final AuthoritiesProvider authoritiesProvider;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = usersRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        List<String> userAuthorities = userEntity.getAuthorities().stream().map(AuthorityEntity::getAuthority).collect(Collectors.toList());

        return User.builder()
                .username(username)
                .password(userEntity.getPassword())
                .authorities(userAuthorities.toArray(String[]::new))
                .build();
    }
}
