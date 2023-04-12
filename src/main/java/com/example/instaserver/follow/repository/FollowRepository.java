package com.example.instaserver.follow.repository;

import com.example.instaserver.follow.entity.Follow;
import com.example.instaserver.user.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    boolean existsByFollowingAndFollower(User following, User follower);

    void deleteByFollowingAndAndFollower(User following, User follower);

    @Query("select f from Follow f join fetch f.follower where f.following=:user")
    List<Follow> findFollowerByFollowing(User user);
}
