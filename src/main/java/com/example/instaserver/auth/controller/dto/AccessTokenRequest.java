package com.example.instaserver.auth.controller.dto;

import lombok.Getter;

@Getter
public class AccessTokenRequest {
    private String refreshToken;
}
