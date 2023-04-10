package com.example.instaserver.post.controller.dto.reply;

import com.example.instaserver.post.entity.Reply;
import lombok.Getter;

@Getter
public class ReplyDto {
    private Long id;
    private String content;
    private String nickname;
    private String profileImageUrl;

    private ReplyDto(Long id, String content, String nickname, String profileImageUrl) {
        this.id = id;
        this.content = content;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }

    public static ReplyDto from(Reply reply) {
        return new ReplyDto(reply.getId(), reply.getContents(),
                reply.getUser().getNickname(), reply.getUser().getProfileImageUrl());
    }
}
