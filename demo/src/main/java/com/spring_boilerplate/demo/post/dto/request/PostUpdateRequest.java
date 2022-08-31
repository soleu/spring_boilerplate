package com.spring_boilerplate.demo.post.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostUpdateRequest {
    @NotBlank
    private String content;

    @Builder
    public PostUpdateRequest(String content) {
        this.content = content;
    }
}
