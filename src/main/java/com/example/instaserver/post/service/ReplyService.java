package com.example.instaserver.post.service;

import com.example.instaserver.post.controller.dto.reply.ReplyRequest;
import com.example.instaserver.post.controller.dto.reply.ReplyResponse;
import com.example.instaserver.post.entity.Comment;
import com.example.instaserver.post.entity.Reply;
import com.example.instaserver.post.repository.ReplyRepository;
import com.example.instaserver.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReplyService {
    private final CommentService commentService;
    private final ReplyRepository replyRepository;

    @Transactional
    public ReplyResponse write(User user, ReplyRequest replyRequest) {
        Comment comment = commentService.getComment(replyRequest.getCommentId());
        Reply newReply = replyRepository.save(new Reply(user, comment, replyRequest.getContent()));
        return ReplyResponse.from(newReply);
    }

}
