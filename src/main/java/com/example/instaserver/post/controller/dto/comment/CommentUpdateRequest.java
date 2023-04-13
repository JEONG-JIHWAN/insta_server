package com.example.instaserver.post.controller.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CommentUpdateRequest {
    @NotNull
    private long id;
    @NotBlank
    private String content;

}
