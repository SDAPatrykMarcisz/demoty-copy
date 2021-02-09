package com.copy.demotywatorycopy.repository.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Data
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "postId")
    private PostEntity post;

    @Column(name = "content")
    private String content;

}
