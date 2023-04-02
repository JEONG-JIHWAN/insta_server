package com.example.instaserver.auth.controller;

import com.example.instaserver.auth.controller.dto.SignInRequest;
import com.example.instaserver.auth.controller.dto.SignInResponse;
import com.example.instaserver.auth.service.AuthService;;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @GetMapping("/login")
    public SignInResponse login(@RequestBody SignInRequest signInRequest) {
        return authService.login(signInRequest);
    }
}
