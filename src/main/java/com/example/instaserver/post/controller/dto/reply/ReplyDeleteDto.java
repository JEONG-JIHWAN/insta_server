package com.example.instaserver.post.controller.dto.reply;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReplyDeleteDto {
    private Long id;

    public ReplyDeleteDto(Long id) {
        this.id = id;
    }
}
