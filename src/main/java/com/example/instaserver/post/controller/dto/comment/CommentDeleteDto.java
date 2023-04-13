package com.example.instaserver.post.controller.dto.comment;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentDeleteDto {
    @NotNull(message = "id must be provided")
    private Long id;

    public CommentDeleteDto(Long id) {
        this.id = id;
    }
}
