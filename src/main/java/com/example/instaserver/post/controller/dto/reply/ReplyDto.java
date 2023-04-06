package com.example.instaserver.post.controller.dto.reply;

import lombok.Getter;

@Getter
public class ReplyDto {
    private Long id;
    private String content;
    private String nickname;
    private String profileImageUrl;
}
