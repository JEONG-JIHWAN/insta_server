package com.example.instaserver.user.controller;

import com.example.instaserver.auth.CurrentUser;
import com.example.instaserver.user.controller.dto.ProfileDto;
import com.example.instaserver.user.controller.dto.SignUpRequest;
import com.example.instaserver.user.controller.dto.UpdateProfileRequest;
import com.example.instaserver.user.controller.dto.UserDto;
import com.example.instaserver.user.entity.User;
import com.example.instaserver.user.service.UserService;
import jakarta.validation.Valid;
import java.io.IOException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto signUp(@ModelAttribute @Valid SignUpRequest signUpRequest) throws IOException {
        return userService.join(signUpRequest);
    }

    @GetMapping("/users/{id}/profile")
    @ResponseStatus(HttpStatus.OK)
    public ProfileDto profile(@PathVariable("id") Long id) {
        return userService.getProfile(id);
    }

    @PutMapping("/users/profile")
    public UserDto update(@CurrentUser User user, @ModelAttribute @Valid UpdateProfileRequest updateProfileRequest)
            throws IOException {
        System.out.println("updateProfileRequest = " + updateProfileRequest.getNickname());
        return userService.update(user, updateProfileRequest);
    }

}
