package com.example.springprac.domain;

import lombok.Data;

@Data
public class Post {
    Long id;
    String title;

    public Post(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Post(String title) {
        this.title = title;
    }
}
