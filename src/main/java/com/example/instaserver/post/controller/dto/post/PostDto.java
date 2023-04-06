package com.example.instaserver.post.controller.dto.post;

import com.example.instaserver.post.controller.dto.comment.CommentDto;
import java.util.List;
import lombok.Getter;

@Getter
public class PostDto {
    private Long id;
    private String content;
    private String imageUrl;
    private List<CommentDto> comments;
}
