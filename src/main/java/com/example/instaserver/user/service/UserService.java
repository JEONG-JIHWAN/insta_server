package com.example.instaserver.user.service;

import com.example.instaserver.common.aws.S3Client;
import com.example.instaserver.common.exception.NotFoundException;
import com.example.instaserver.user.controller.dto.SignUpRequest;
import com.example.instaserver.user.controller.dto.UserDto;
import com.example.instaserver.user.entity.User;
import com.example.instaserver.user.repository.UserRepository;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final S3Client s3Client;
    private final PasswordEncoder passwordEncoder;

    public UserDto join(SignUpRequest signUpRequest) throws IOException {
        String newUserNickname = signUpRequest.getNickname();
        MultipartFile newUserProfileImage = signUpRequest.getProfile_image();
        checkDuplicateNickname(newUserNickname);
        String profileImageUrl = s3Client.uploadImage(newUserProfileImage);
        String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword());
        return new UserDto(userRepository.save(User.newUser(newUserNickname, encodedPassword, profileImageUrl)));
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("해당 사용자가 존재하지 않습니다."));
    }

    public User getUserByNickname(String nickname) {
        return userRepository.findByNickname(nickname).orElseThrow(() -> new NotFoundException("해당 사용자가 존재하지 않습니다."));
    }

    private void checkDuplicateNickname(String nickname) {
        userRepository.findByNickname(nickname)
                .ifPresent(u -> {throw new IllegalArgumentException("해당 닉네임이 이미 존재합니다.");});
    }

}
