package com.example.instaserver.post.controller.dto.post;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class PostUpdateRequest {
    private Long id;
    private MultipartFile image;
    private String content;

    public PostUpdateRequest(Long id, MultipartFile image, String content) {
        this.id = id;
        this.image = image;
        this.content = content;
    }
}
