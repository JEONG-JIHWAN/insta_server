package com.example.instaserver.post.controller.dto.reply;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ReplyRequest {
    @JsonProperty("comment_id")
    private Long commentId;
    private String content;
}
