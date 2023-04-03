package com.example.instaserver.follow.controller;

import com.example.instaserver.auth.CurrentUser;
import com.example.instaserver.follow.controller.dto.FollowRequest;
import com.example.instaserver.follow.controller.dto.FollowResponse;
import com.example.instaserver.follow.service.FollowService;
import com.example.instaserver.user.entity.User;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;

    @GetMapping("/ss")
    public FollowResponse s(){
        return new FollowResponse(1);
    }
    @PostMapping("/follow")
    public FollowResponse follow(@CurrentUser User user, @RequestBody FollowRequest followRequest) {
        return followService.follow(user, followRequest.getUserId());
    }

    @DeleteMapping("/follow/cancel")
    public FollowResponse unFollow(@CurrentUser User user, @RequestBody FollowRequest cancelFollowRequest){
        return followService.unFollow(user, cancelFollowRequest.getUserId());
    }
}
