package com.example.instaserver.user.controller.dto;

import com.example.instaserver.user.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserDto {
    private Long id;
    private String nickname;
    @JsonProperty("profile_image_url")
    private String profileImageUrl;

    public UserDto(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.profileImageUrl = user.getProfileImageUrl();
    }
}
