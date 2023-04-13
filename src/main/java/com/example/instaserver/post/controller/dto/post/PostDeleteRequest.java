package com.example.instaserver.post.controller.dto.post;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PostDeleteRequest {
    @NotNull
    private Long id;
}
