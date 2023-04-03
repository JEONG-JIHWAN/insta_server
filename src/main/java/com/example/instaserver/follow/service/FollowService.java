package com.example.instaserver.follow.service;

import com.example.instaserver.follow.controller.dto.FollowResponse;
import com.example.instaserver.follow.repository.FollowRepository;
import com.example.instaserver.follow.entity.Follow;
import com.example.instaserver.user.entity.User;
import com.example.instaserver.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FollowService {
    private final FollowRepository followRepository;
    private final UserService userService;

    @Transactional
    public FollowResponse follow(User user, Long followId) {
        User loginUser = userService.getUser(user.getId());
        User followUser = userService.getUser(followId);

        checkDifferentId(user.getId(), followId);
        checkCanFollow(loginUser, followUser);

        loginUser.plusFollowingCount();
        followUser.plusFollowedCount();
        followRepository.save(Follow.newFollow(loginUser, followUser));
        return new FollowResponse(followUser.getId());
    }

    @Transactional
    public FollowResponse unFollow(User user, Long unFollowId) {
        User loginUser = userService.getUser(user.getId());
        User unFollowUser = userService.getUser(unFollowId);

        checkDifferentId(user.getId(), unFollowId);
        checkCanUnFollow(loginUser, unFollowUser);
        loginUser.minusFollowingCount();
        unFollowUser.minusFollowedCount();
        followRepository.deleteByFollowingAndAndFollower(loginUser, unFollowUser);
        return new FollowResponse(unFollowUser.getId());
    }

    private void checkDifferentId(Long loginId, Long followId) {
        if(loginId == followId) { throw new IllegalArgumentException("");}
    }

    private void checkCanFollow(User followingUser, User followedUser){
        if(followRepository.existsByFollowingAndFollower(followingUser, followedUser)){
            throw new IllegalArgumentException("");
        }
    }

    private void checkCanUnFollow(User followingUser, User followedUser){
        if(!followRepository.existsByFollowingAndFollower(followingUser, followedUser)){
            throw new IllegalArgumentException("");
        }
    }
}
