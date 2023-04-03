package com.example.instaserver.follow.controller.dto;

import lombok.Getter;

@Getter
public class FollowResponse {
    private long userId;

    public FollowResponse(long userId) {
        this.userId = userId;
    }
}
