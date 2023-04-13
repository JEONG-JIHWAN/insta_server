package com.example.instaserver.post.controller.dto.post;

import com.example.instaserver.post.controller.dto.comment.CommentDto;
import com.example.instaserver.post.entity.Comment;
import com.example.instaserver.post.entity.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public class PostDto {
    private Long id;
    private String content;
    @JsonProperty("image_url")
    private String imageUrl;
    private List<CommentDto> comments;

    private PostDto(Long id, String content, String imageUrl, List<CommentDto> comments) {
        this.id = id;
        this.content = content;
        this.imageUrl = imageUrl;
        this.comments = comments;
    }

    public static PostDto from(Post post) {
        return new PostDto(post.getId(),
                post.getContents(),
                post.getProfileImageUrl(),
                post.getComments().stream().map(comment -> CommentDto.from(comment)).collect(Collectors.toList()));
    }
}
