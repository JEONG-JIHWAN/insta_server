package com.example.instaserver.follow.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class FollowRequest {
    @JsonProperty("user_id")
    @NotNull(message = "userId must be provided")
    private Long userId;
}
