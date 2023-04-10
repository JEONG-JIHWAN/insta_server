package com.example.instaserver.post.controller.dto.comment;

import com.example.instaserver.post.controller.dto.reply.ReplyDto;
import com.example.instaserver.post.entity.Comment;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public class CommentDto {
    private Long id;
    private String content;
    private String nickname;
    private String profileImageUrl;
    private List<ReplyDto> replies;

    private CommentDto(Long id, String content, String nickname, String profileImageUrl, List<ReplyDto> replies) {
        this.id = id;
        this.content = content;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
        this.replies = replies;
    }

    public static CommentDto from(Comment comment) {
        return new CommentDto(comment.getId(), comment.getContents(),
                comment.getUser().getNickname(), comment.getUser().getProfileImageUrl(),
                comment.getReplies().stream().map(reply -> ReplyDto.from(reply)).collect(Collectors.toList()));
    }
}
