package com.example.instaserver.post.controller.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentDeleteDto {
    private Long id;

    public CommentDeleteDto(Long id) {
        this.id = id;
    }
}
