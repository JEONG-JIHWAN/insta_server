package com.example.instaserver.post.controller.dto.post;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class PostDeleteRequest {
    @NotEmpty
    private Long id;
}
