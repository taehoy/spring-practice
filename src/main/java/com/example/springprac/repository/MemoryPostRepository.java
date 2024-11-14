package com.example.springprac.repository;

import com.example.springprac.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryPostRepository implements PostRepository{

    private static Map<Long, Post> store = new HashMap<>();


    @Override
    public Post save(Post post) {
        store.put(post.getId(), post);
        Post savedPost = store.get(post.getId());
        return savedPost;
    }

    @Override
    public Post findById(Long postId) {
        Post post = store.get(postId);
        return post;
    }

    @Override
    public List<Post> findAll() {

        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(Long postId) {
        store.remove(postId);
    }

    @Override
    public Post update(Long postId, Post post) {
        store.put(postId, post);
        Post updatedPost = store.get(postId);
        return updatedPost;
    }
}
