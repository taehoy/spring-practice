package com.example.springprac.service;

import com.example.springprac.domain.Post;

import java.util.List;

public interface PostService {
    Post insertPost(Post post);
    List<Post> findAllPost();
    Post findPostById(Long postId);
    Post updatePostById(Long postId, Post post);
    void deletePost(Long postId);
}
