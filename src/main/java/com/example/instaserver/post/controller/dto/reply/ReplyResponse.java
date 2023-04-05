package com.example.instaserver.post.controller.dto.reply;

import com.example.instaserver.post.entity.Reply;
import lombok.Getter;

@Getter
public class ReplyResponse {
    private Long id;
    private String content;

    private ReplyResponse(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public static ReplyResponse from(Reply reply) {
        return new ReplyResponse(reply.getId(), reply.getContents());
    }
}
