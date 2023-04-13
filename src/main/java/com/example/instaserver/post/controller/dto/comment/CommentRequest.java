package com.example.instaserver.post.controller.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CommentRequest {
    @NotNull(message = "postId must be provided")
    private Long postId;
    @NotBlank(message = "blank is not allowed")
    private String content;
}
