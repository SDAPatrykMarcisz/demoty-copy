package com.copy.demotywatorycopy.repository.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "top_text")
    private String topText;

    @Column(name = "bottom_text")
    private String bottomText;

    @Column(name = "image_path")
    private String imagePath;

    @OneToMany(mappedBy = "post")
    private List<VoteEntity> votes;

}
