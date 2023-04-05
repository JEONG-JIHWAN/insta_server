package com.example.instaserver.post.controller;

import com.example.instaserver.auth.CurrentUser;
import com.example.instaserver.post.controller.dto.post.PostRequest;
import com.example.instaserver.post.controller.dto.post.PostResponse;
import com.example.instaserver.post.service.PostService;
import com.example.instaserver.user.entity.User;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping(path = "post")
    public PostResponse posting(@CurrentUser User user, @ModelAttribute PostRequest postRequest) throws IOException {
        return postService.write(user, postRequest);
    }
}
