package com.example.instaserver.user.service;

import com.example.instaserver.user.controller.dto.SignUpRequest;
import com.example.instaserver.user.controller.dto.UserDto;
import com.example.instaserver.user.entity.User;
import com.example.instaserver.user.repository.UserRepository;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto join(SignUpRequest signUpRequest) throws IOException {
        checkDuplicateNickname(signUpRequest.getNickname());
        return new UserDto(userRepository.save(User.newUser(signUpRequest)));
    }

    private void checkDuplicateNickname(String nickname) {
        userRepository.findByNickname(nickname)
                .ifPresent(u -> {
                    throw new IllegalArgumentException("해당 닉네임이 이미 존재합니다.");
                });
    }
}
