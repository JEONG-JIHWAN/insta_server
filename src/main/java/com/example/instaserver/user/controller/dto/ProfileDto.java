package com.example.instaserver.user.controller.dto;

import com.example.instaserver.user.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ProfileDto {
    private String nickname;
    @JsonProperty("profile_image_url")
    private String profileImageUrl;
    private int follower;
    private int following;

    private ProfileDto(String nickname, String profileImageUrl, int follower, int following) {
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
        this.follower = follower;
        this.following = following;
    }

    public static ProfileDto from(User user){
        return new ProfileDto(user.getNickname(), user.getProfileImageUrl(),
                user.getFollowerCount(), user.getFollowingCount());
    }
}
