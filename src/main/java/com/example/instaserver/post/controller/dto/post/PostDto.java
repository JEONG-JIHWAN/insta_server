package com.example.instaserver.post.controller.dto.post;

import com.example.instaserver.post.controller.dto.comment.CommentDto;
import com.example.instaserver.post.entity.Post;
import java.util.List;
import lombok.Getter;

@Getter
public class PostDto {
    private Long id;
    private String content;
    private String imageUrl;

    private PostDto(Long id, String content, String imageUrl) {
        this.id = id;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public static PostDto from(Post post) {
        return new PostDto(post.getId(), post.getContents(), post.getProfileImageUrl());
    }
}
