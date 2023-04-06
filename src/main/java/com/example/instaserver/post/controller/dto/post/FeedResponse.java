package com.example.instaserver.post.controller.dto.post;

import java.util.List;
import lombok.Getter;

@Getter
public class FeedResponse {
    private List<PostDto> posts;
}
