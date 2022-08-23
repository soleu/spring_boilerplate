package com.spring_boilerplate.demo.post;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private Post( final String title, final String content) {
        this.title = title;
        this.content = content;
    }

    public static Post newInstance(String title,String content) {
    return new Post( title, content);
    }
}
