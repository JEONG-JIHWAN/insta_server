package com.example.instaserver.post.controller.dto.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class PostUpdateRequest {
    @NotNull
    private Long id;
    @NotNull
    private MultipartFile image;
    @NotBlank
    private String content;

    public PostUpdateRequest(Long id, MultipartFile image, String content) {
        this.id = id;
        this.image = image;
        this.content = content;
    }
}
