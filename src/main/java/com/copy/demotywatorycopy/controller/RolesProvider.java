package com.copy.demotywatorycopy.controller;


import com.copy.demotywatorycopy.repository.dao.AuthorityEntity;
import com.copy.demotywatorycopy.repository.AuthoritiesRepository;
import com.copy.demotywatorycopy.repository.dao.UserEntity;
import com.copy.demotywatorycopy.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
@Profile("inMemoryDatabase")
public class RolesProvider implements CommandLineRunner {

    private final AuthoritiesRepository authoritiesRepository;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        AuthorityEntity adminRole = new AuthorityEntity();
        adminRole.setAuthority("ROLE_ADMIN");
        adminRole = authoritiesRepository.save(adminRole);

        AuthorityEntity userRole = new AuthorityEntity();
        userRole.setAuthority("ROLE_USER");
        userRole = authoritiesRepository.save(userRole);

        UserEntity admin = new UserEntity();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setAuthorities(Arrays.asList(adminRole, userRole));
        usersRepository.save(admin);
    }
}
