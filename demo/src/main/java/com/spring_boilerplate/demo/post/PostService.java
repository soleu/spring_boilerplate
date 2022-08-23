package com.spring_boilerplate.demo.post;

import com.spring_boilerplate.demo.post.dto.request.PostCreateRequest;
import com.spring_boilerplate.demo.post.dto.response.PostListResponse;
import com.spring_boilerplate.demo.post.dto.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.spring_boilerplate.demo.post.Post.newInstance;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public final void createPost(PostCreateRequest request) {
        Post post = newInstance(request.getTitle(), request.getContent());
        postRepository.save(post);
    }

    public final PostResponse getPostById(final Long postId) {
        final Post post = postRepository.findById(postId)
                .orElseThrow(NotExistsPostException::new);
        return PostResponse.of(post);
    }

    public final PostListResponse getAllPosts() {
        List<Post> posts = postRepository.findAll();

        return new PostListResponse(posts.stream()
                .map(PostResponse::of)
                .collect(Collectors.toList()));
    }

}