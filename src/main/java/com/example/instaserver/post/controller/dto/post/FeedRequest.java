package com.example.instaserver.post.controller.dto.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class FeedRequest {
    @JsonProperty("user_id")
    private Long userId;
}
