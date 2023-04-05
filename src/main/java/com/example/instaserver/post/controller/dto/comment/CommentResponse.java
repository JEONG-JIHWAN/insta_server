package com.example.instaserver.post.controller.dto.comment;

import com.example.instaserver.post.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponse {
    private Long id;
    private String content;

    private CommentResponse(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public static CommentResponse from(Comment comment) {
        return new CommentResponse(comment.getId(), comment.getContents());
    }
}
