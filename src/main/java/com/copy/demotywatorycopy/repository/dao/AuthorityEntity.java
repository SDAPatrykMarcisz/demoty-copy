package com.copy.demotywatorycopy.repository.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "authorities")
public class AuthorityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authority;

}
