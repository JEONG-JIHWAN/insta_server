package com.example.instaserver.post.controller.dto.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class FeedRequest {
    @JsonProperty("user_id")
    @NotNull(message = "userId must be provided")
    private Long userId;
    @NotNull(message = "userId must be provided")
    private Long cursor;
}
