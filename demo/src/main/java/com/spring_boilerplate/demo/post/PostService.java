package com.spring_boilerplate.demo.post;

import com.spring_boilerplate.demo.post.dto.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public final PostResponse getPostById(final Long postId) {
        final Post post = postRepository.findById(postId)
                .orElseThrow();
        return PostResponse.of(post);
    }
}