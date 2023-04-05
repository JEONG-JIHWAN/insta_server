package com.example.instaserver.post.controller.dto.comment;

import lombok.Getter;

@Getter
public class CommentRequest {
    private Long postId;
    private String content;
}
