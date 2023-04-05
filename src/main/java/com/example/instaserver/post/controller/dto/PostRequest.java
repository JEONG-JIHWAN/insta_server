package com.example.instaserver.post.controller.dto;

import lombok.Getter;

import org.springframework.web.multipart.MultipartFile;

@Getter
public class PostRequest {
    private MultipartFile image;
    private String content;

    public PostRequest(MultipartFile image, String content) {
        this.image = image;
        this.content = content;
    }
}
