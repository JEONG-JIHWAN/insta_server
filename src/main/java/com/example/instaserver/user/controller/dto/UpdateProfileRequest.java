package com.example.instaserver.user.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class UpdateProfileRequest {
    private String nickname;
    private MultipartFile profileImage;

}
