package com.example.instaserver.post.controller.dto.reply;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ReplyUpdateRequest {
    @NotNull
    private Long id;
    @NotBlank
    private String content;
}
