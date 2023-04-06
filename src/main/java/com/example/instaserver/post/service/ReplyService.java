package com.example.instaserver.post.service;

import com.example.instaserver.common.exception.NotFoundException;
import com.example.instaserver.post.controller.dto.reply.ReplyDeleteDto;
import com.example.instaserver.post.controller.dto.reply.ReplyRequest;
import com.example.instaserver.post.controller.dto.reply.ReplyResponse;
import com.example.instaserver.post.entity.Comment;
import com.example.instaserver.post.entity.Reply;
import com.example.instaserver.post.repository.ReplyRepository;
import com.example.instaserver.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

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

    @Transactional
    public ReplyDeleteDto delete(User user, ReplyDeleteDto replyDeleteDto) {
        Assert.notNull(user, "사용자가 존재하지 않습니다.");
        Assert.notNull(replyDeleteDto.getId(), "답글 Id가 존재하지 않습니다.");
        Reply reply = getReply(replyDeleteDto.getId());
        Assert.isTrue(user.getId() == reply.getUser().getId(), "해당 답글을 삭제할 수 없습니다. ");

        replyRepository.delete(reply);
        return new ReplyDeleteDto(reply.getId());
    }

    public Reply getReply(Long replyId){
        return replyRepository.findById(replyId)
                .orElseThrow(() -> new NotFoundException("해당 답글이 존재하지 않습니다."));
    }
}
