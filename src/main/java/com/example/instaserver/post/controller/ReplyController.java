package com.example.instaserver.post.controller;

import com.example.instaserver.auth.CurrentUser;
import com.example.instaserver.post.controller.dto.reply.ReplyRequest;
import com.example.instaserver.post.controller.dto.reply.ReplyResponse;
import com.example.instaserver.post.service.ReplyService;
import com.example.instaserver.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;
    @PostMapping("reply")
    public ReplyResponse reply(@CurrentUser User user, @RequestBody ReplyRequest replyRequest) {
        System.out.println(replyRequest.getCommentId());
        return replyService.write(user, replyRequest);
    }
}
