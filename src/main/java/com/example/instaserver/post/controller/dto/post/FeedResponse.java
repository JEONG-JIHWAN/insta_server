package com.example.instaserver.post.controller.dto.post;

import com.example.instaserver.post.entity.Post;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.springframework.data.domain.Slice;

@Getter
public class FeedResponse {
    private List<PostDto> posts;

    private FeedResponse(List<PostDto> posts) {
        this.posts = posts;
    }

    public static FeedResponse from(Slice<Post> posts) {
        return new FeedResponse(posts.stream().map(post -> PostDto.from(post)).collect(Collectors.toList()));
    }
}
