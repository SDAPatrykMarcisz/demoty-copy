package com.copy.demotywatorycopy.security;

import com.copy.demotywatorycopy.repository.dao.AuthorityEntity;
import com.copy.demotywatorycopy.repository.dao.UserEntity;
import com.copy.demotywatorycopy.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Primary
public class CustomUserDetails implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = usersRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        return User.builder()
                .username(username)
                .password(userEntity.getPassword())
                .authorities(userEntity.getAuthorities().stream().map(AuthorityEntity::getAuthority).toArray(String[]::new))
                .build();
    }
}
