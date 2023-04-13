package com.example.instaserver.follow.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class FollowResponse {
    @NotNull(message = "userId must be provided")
    private Long userId;

    public FollowResponse(Long userId) {
        this.userId = userId;
    }
}
