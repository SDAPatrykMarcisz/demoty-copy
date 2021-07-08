package com.copy.demotywatorycopy.config;

import com.copy.demotywatorycopy.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Transactional
public class H2DatabaseResetController {

    private final AuthoritiesRepository authoritiesRepository;
    private final CommentsRepository commentsRepository;
    private final PostsRepository postsRepository;
    private final UsersRepository usersRepository;
    private final VotesRepository votesRepository;
    private final H2DatabaseInitialDataProvider rolesProvider;

    @PostMapping
    public void reset(){
        authoritiesRepository.deleteAll();
        commentsRepository.deleteAll();
        postsRepository.deleteAll();
        usersRepository.deleteAll();
        votesRepository.deleteAll();

        rolesProvider.run();
    }

}
