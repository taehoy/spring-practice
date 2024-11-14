package com.example.springprac.repository;

import com.example.springprac.domain.Post;

import java.util.List;

public interface PostRepository {
    Post save(Post post);
    Post findById(Long postId);
    List<Post> findAll();
    void delete(Long postId);
    Post update(Long postId, Post post);
}
