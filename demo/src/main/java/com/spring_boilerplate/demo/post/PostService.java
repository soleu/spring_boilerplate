package com.spring_boilerplate.demo.post;

import com.spring_boilerplate.demo.post.dto.request.PostCreateRequest;
import com.spring_boilerplate.demo.post.dto.request.PostUpdateRequest;
import com.spring_boilerplate.demo.post.dto.response.PostListResponse;
import com.spring_boilerplate.demo.post.dto.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void createPost(PostCreateRequest request) {
        Post post = Post.newInstance(request.getTitle(), request.getContent());
        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public PostResponse getPostById(final Long postId) {
        final Post post = postRepository.findById(postId)
                .orElseThrow(NotExistsPostException::new);
        return PostResponse.of(post);
    }

    @Transactional(readOnly = true)
    public PostListResponse getAllPosts() {
        List<Post> posts = postRepository.findAll();

        return new PostListResponse(posts.stream()
                .map(PostResponse::of)
                .collect(Collectors.toList()));
    }

    public void updatePost(Long postId, final PostUpdateRequest request) {
        final Post post = postRepository.findById(postId)
                .orElseThrow(NotExistsPostException::new);

        post.updateContent(request.getContent());
    }

    public void deletePost(Long postId) {
        final Post post = postRepository.findById(postId)
                .orElseThrow(NotExistsPostException::new);

        postRepository.deleteById(postId);
    }
}