package com.example.instaserver.follow.repository;

import com.example.instaserver.follow.entity.Follow;
import com.example.instaserver.user.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    boolean existsByFollowingAndFollower(User following, User follower);

    void deleteByFollowingAndAndFollower(User following, User follower);

    @Query("select f.follower from Follow f left join User u where f.following=:user")
    List<User> findFollowerByFollowing(User user);
}
