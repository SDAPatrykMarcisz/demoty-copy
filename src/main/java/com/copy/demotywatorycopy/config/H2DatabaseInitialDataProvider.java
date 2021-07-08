package com.copy.demotywatorycopy.config;


import com.copy.demotywatorycopy.model.votes.VoteType;
import com.copy.demotywatorycopy.repository.*;
import com.copy.demotywatorycopy.repository.dao.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class H2DatabaseInitialDataProvider implements CommandLineRunner {

    private final AuthoritiesRepository authoritiesRepository;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    private final CommentsRepository commentsRepository;
    private final PostsRepository postsRepository;
    private final VotesRepository votesRepository;

    @Override
    public void run(String... args) {
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

        CommentEntity comment = new CommentEntity();
        comment.setContent("fajne");
        comment.setUser(admin);

        PostEntity post = new PostEntity();
        post.setBottomText("Hello World");
        post.setImagePath("https://www.tapeciarnia.pl/tapety/normalne/25261_koteczek.jpg");
        post.setUser(admin);

        VoteEntity vote = new VoteEntity();
        vote.setVoteType(VoteType.VOTE_UP);
        votesRepository.save(vote);

        postsRepository.save(post);
        commentsRepository.save(comment);
        //create comments
        ArrayList<CommentEntity> comments = new ArrayList<>(Collections.singletonList(comment));

        //add two-way connections
        post.setComments(comments);
        post.setVotes(new ArrayList<>(Collections.singletonList(vote)));

        vote.setPost(post);

        admin.setComments(comments);

        comment.setPost(post);
        comment.setUser(admin);

    }
}
