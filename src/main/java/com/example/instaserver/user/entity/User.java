package com.example.instaserver.user.entity;

import com.example.instaserver.common.entity.BaseEntity;
import com.example.instaserver.follow.entity.Follow;
import com.example.instaserver.user.controller.dto.UpdateProfileRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Column(columnDefinition = "varchar(80)", unique = true, nullable = false)
    String nickname;

    String password;

    String profileImageUrl;

    int followingCount;

    int followerCount;


    private User(String nickname, String password, String profileImageUrl, int followingCount, int followerCount) {
        this.nickname = nickname;
        this.password = password;
        this.profileImageUrl = profileImageUrl;
        this.followingCount = followingCount;
        this.followerCount = followerCount;
    }

    public static User newUser(String nickname, String encodedPassword, String profileImageUrl){
        return new User(nickname, encodedPassword, profileImageUrl, 0 ,0);
    }

    public void update(String nickname, String profileImageUrl){
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }

    public int plusFollowingCount(){
        return ++followingCount;
    }

    public int plusFollowedCount(){
        return ++followerCount;
    }

    public int minusFollowingCount(){
        return --followingCount;
    }

    public int minusFollowedCount(){
        return --followerCount;
    }
}
