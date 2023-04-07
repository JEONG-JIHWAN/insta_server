package com.example.instaserver.post.controller.dto.post;

import com.example.instaserver.post.entity.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PostResponse {
    private Long id;

    @JsonProperty("image_url")
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
