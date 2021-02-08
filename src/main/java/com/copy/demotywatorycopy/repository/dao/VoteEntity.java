package com.copy.demotywatorycopy.repository.dao;

import com.copy.demotywatorycopy.model.votes.VoteType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "votes")
public class VoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "postId")
    private PostEntity post;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private VoteType voteType;

}
