package com.copy.demotywatorycopy.repository.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String mail;
    private boolean active;

    @ManyToMany
    private List<AuthorityEntity> authorities;

    @OneToMany(mappedBy = "user")
    private List<CommentEntity> comments;

}

