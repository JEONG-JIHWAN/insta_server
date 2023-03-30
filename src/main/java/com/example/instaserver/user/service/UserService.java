package com.example.instaserver.user.service;

import com.example.instaserver.common.aws.S3Client;
import com.example.instaserver.user.controller.dto.SignUpRequest;
import com.example.instaserver.user.controller.dto.UserDto;
import com.example.instaserver.user.entity.User;
import com.example.instaserver.user.repository.UserRepository;
import java.io.IOException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final S3Client s3Client;

    public UserDto join(SignUpRequest signUpRequest) throws IOException {
        String newUserNickname = signUpRequest.getNickname();
        MultipartFile newUserProfileImage = signUpRequest.getProfile_image();
        checkDuplicateNickname(newUserNickname);
        String profileImageUrl = s3Client.uploadImage(newUserProfileImage);
        return new UserDto(userRepository.save(User.newUser(newUserNickname, profileImageUrl)));
    }

    private void checkDuplicateNickname(String nickname) {
        userRepository.findByNickname(nickname)
                .ifPresent(u -> {
                    throw new IllegalArgumentException("해당 닉네임이 이미 존재합니다.");
                });
    }
}
