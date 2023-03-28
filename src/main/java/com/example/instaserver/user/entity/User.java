package com.example.instaserver.user.entity;

import com.example.instaserver.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Column(columnDefinition = "varchar(80)", unique = true, nullable = false)
    String nickname;
    @Lob
    @Column(columnDefinition="BLOB")
    byte[] profileImage;
}
