package com.example.instaserver.post.controller.dto.comment;

import com.example.instaserver.post.controller.dto.reply.ReplyDto;
import java.util.List;
import lombok.Getter;

@Getter
public class CommentDto {
    private Long id;
    private String content;
    private String nickname;
    private String profileImageUrl;
    private List<ReplyDto> replies;
}
