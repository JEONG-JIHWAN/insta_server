package com.example.instaserver.post.controller.dto.post;

import com.example.instaserver.post.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostDeleteResponse {
    private Long id;

    private PostDeleteResponse(Long id) {
        this.id = id;
    }

    public static PostDeleteResponse from(Post post){
        return new PostDeleteResponse(post.getId());
    }
}
