package com.spring_boilerplate.demo.post;


import com.spring_boilerplate.demo.post.dto.request.PostCreateRequest;
import com.spring_boilerplate.demo.post.dto.request.PostUpdateRequest;
import com.spring_boilerplate.demo.post.dto.response.PostListResponse;
import com.spring_boilerplate.demo.post.dto.response.PostResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @PostMapping("")
    @ApiOperation("글을 생성합니다.")
    public void createPost(@Valid @RequestBody PostCreateRequest request) {
        postService.createPost(request);
    }

    @GetMapping("/{postId}")
    @ApiOperation("글을 아이디별로 조회합니다.")
    public PostResponse getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @GetMapping("")
    @ApiOperation("글 목록을 조회합니다.")
    public PostListResponse getAllPosts() {
        return postService.getAllPosts();
    }

    @PutMapping("/{postId}")
    @ApiOperation("글 내용을 수정합니다.")
    public void updatePost(
            @PathVariable Long postId,
            @Valid @RequestBody PostUpdateRequest request) {
        postService.updatePost(postId, request);
    }

}
