package com.example.instaserver.auth.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignInRequest {
    private String nickname;
    private String password;
}
