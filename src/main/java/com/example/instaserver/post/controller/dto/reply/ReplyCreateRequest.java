package com.example.instaserver.post.controller.dto.reply;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ReplyCreateRequest {
    @JsonProperty("comment_id")
    @NotNull
    private Long commentId;
    @NotBlank
    private String content;
}
