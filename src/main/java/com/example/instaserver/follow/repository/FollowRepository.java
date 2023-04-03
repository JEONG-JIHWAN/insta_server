package com.example.instaserver.follow.repository;

import com.example.instaserver.follow.entity.Follow;
import com.example.instaserver.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    boolean existsByFollowingAndFollower(User following, User follower);

    void deleteByFollowingAndAndFollower(User following, User follower);
}
