package com.example.instaserver.post.controller.dto;

import com.example.instaserver.post.entity.Post;
import lombok.Getter;

@Getter
public class PostResponse {
    private Long id;

    private String imageUrl;

    private String content;

    private PostResponse(Long id, String imageUrl, String content) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.content = content;
    }

    public static PostResponse from(Post post) {
        return new PostResponse(post.getId(), post.getProfileImageUrl(), post.getContents());
    }
}
