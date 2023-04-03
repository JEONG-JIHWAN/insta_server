package com.example.instaserver.follow.entity;

import com.example.instaserver.common.entity.BaseEntity;
import com.example.instaserver.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Follow extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "following_id")
    private User following;
    @ManyToOne
    @JoinColumn(name = "follower_id")
    private User follower;

    private Follow(User followingId, User followedId) {
        this.following = followingId;
        this.follower = followedId;
    }

    public static Follow newFollow(User followingUser, User followdUser) {
        return new Follow(followingUser, followdUser);
    }
}
