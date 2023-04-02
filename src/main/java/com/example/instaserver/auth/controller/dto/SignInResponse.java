package com.example.instaserver.auth.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInResponse {
    private String accessToken;
    private String refreshToken;
}
