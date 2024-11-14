package com.example.springprac.controller;


import com.example.springprac.domain.Post;
import com.example.springprac.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public String home(){
        Post postA = new  Post(1L, "postA");
        Post postB = new  Post(2L, "postB");

        postService.insertPost(postA);
        postService.insertPost(postB);
        Post findedPost = postService.findPostById(postA.getId());
        List<Post> allPost = postService.findAllPost();

        List<String> list = new ArrayList<>();

        for (Post post : allPost) {
            list.add(post.getTitle());
        }

        return list.get(1).toString();
    }
}
