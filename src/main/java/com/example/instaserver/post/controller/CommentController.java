package com.example.instaserver.post.controller;

import com.example.instaserver.auth.CurrentUser;
import com.example.instaserver.post.controller.dto.comment.CommentRequest;
import com.example.instaserver.post.controller.dto.comment.CommentResponse;
import com.example.instaserver.post.service.CommentService;
import com.example.instaserver.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("comment")
    public CommentResponse comment(@CurrentUser User user, @RequestBody CommentRequest commentRequest) {
        return commentService.write(user, commentRequest);
    }
}
