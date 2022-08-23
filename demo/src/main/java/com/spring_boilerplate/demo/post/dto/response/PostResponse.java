package com.spring_boilerplate.demo.post.dto.response;

import com.spring_boilerplate.demo.post.Post;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponse {
    private Long postId;
    private String title;
    private String content;

    public static PostResponse of(Post post) {
        return new PostResponse(post.getId(), post.getTitle(), post.getContent());
    }
}
