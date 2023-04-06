package com.example.instaserver.post.controller;

import com.example.instaserver.auth.CurrentUser;
import com.example.instaserver.post.controller.dto.reply.ReplyDeleteDto;
import com.example.instaserver.post.controller.dto.reply.ReplyRequest;
import com.example.instaserver.post.controller.dto.reply.ReplyResponse;
import com.example.instaserver.post.service.ReplyService;
import com.example.instaserver.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;
    @PostMapping("reply")
    @ResponseStatus(HttpStatus.CREATED)
    public ReplyResponse reply(@CurrentUser User user, @RequestBody ReplyRequest replyRequest) {
        return replyService.write(user, replyRequest);
    }

    @DeleteMapping("reply")
    @ResponseStatus(HttpStatus.OK)
    public ReplyDeleteDto deleteReply(@CurrentUser User user, @RequestBody ReplyDeleteDto replyDeleteDto) {
        return replyService.delete(user, replyDeleteDto);
    }
}
