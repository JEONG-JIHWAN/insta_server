package com.example.instaserver.post.controller.dto.reply;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReplyDeleteDto {
    @NotNull
    private Long id;

    public ReplyDeleteDto(Long id) {
        this.id = id;
    }
}
