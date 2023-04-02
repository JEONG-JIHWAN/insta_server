package com.example.instaserver.user.entity;

import com.example.instaserver.common.entity.BaseEntity;
import com.example.instaserver.user.controller.dto.SignUpRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import java.io.IOException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {
    @Column(columnDefinition = "varchar(80)", unique = true, nullable = false)
    String nickname;

    String password;

    String profileImageUrl;

    public static User newUser(String nickname, String encodedPassword, String profileImageUrl){
        return new User(nickname, encodedPassword, profileImageUrl);
    }
}
