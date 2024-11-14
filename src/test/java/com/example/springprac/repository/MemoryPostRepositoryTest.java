package com.example.springprac.repository;

import com.example.springprac.domain.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryPostRepositoryTest {

    PostRepository postRepository = new MemoryPostRepository();

    @Test
    @DisplayName("게시글 등록")
    void save(){
        //given
        Post post = new Post( 1L, "안녕하세요!");

        //when
        Post savedPost = postRepository.save(post);

        //then
        assertThat(savedPost.getId()).isEqualTo(post.getId());
    }

    @Test
    @DisplayName("게시글 하나만 조회")
    void findById() {
        //given
        Post post = new Post( 1L, "안녕하세요!");
        postRepository.save(post);

        //when
        Post findedPost = postRepository.findById(post.getId());

        //then
        assertThat(findedPost).isInstanceOf(Post.class);
        assertThat(findedPost.getId()).isEqualTo(post.getId());
    }

    @Test
    @DisplayName("게시글 전부 조회")
    void findAll() {
        //given
        Post postA = new Post( 1L, "postA");
        Post postB = new Post( 2L, "postB");
        postRepository.save(postA);
        postRepository.save(postB);

        //when
        List<Post> all = postRepository.findAll();

        //then
        assertThat(all.size()).isEqualTo(2);
    }

    @Test
    void delete() {
        Post postA = new Post( 1L, "postA");
        Post postB = new Post( 2L, "postB");
        postRepository.save(postA);
        postRepository.save(postB);

        //when
        postRepository.delete(1L);
        List<Post> all = postRepository.findAll();

        //then
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    void update() {
        //given
        Post post = new Post( 1L, "postA");
        postRepository.save(post);

        //when
        post.setTitle("postB");
        postRepository.update(1L, post);
        Post findedPost = postRepository.findById(1L);

        //then
        assertThat(findedPost.getTitle()).isEqualTo("postB");

    }
}
