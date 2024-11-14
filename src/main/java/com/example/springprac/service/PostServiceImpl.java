package com.example.springprac.service;

import com.example.springprac.domain.Post;
import com.example.springprac.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post insertPost(Post post) {
        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    @Override
    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Post findPostById(Long postId) {
        return postRepository.findById(postId);
    }

    @Override
    public Post updatePostById(Long postId, Post post) {
        return postRepository.update(postId, post);
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.delete(postId);
    }
}
