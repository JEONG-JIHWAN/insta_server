package com.example.instaserver.post.controller.dto.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import org.springframework.web.multipart.MultipartFile;

@Getter
public class PostRequest {
    @NotNull
    private MultipartFile image;
    @NotBlank
    private String content;

    public PostRequest(MultipartFile image, String content) {
        this.image = image;
        this.content = content;
    }
}
