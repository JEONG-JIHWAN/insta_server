package com.example.instaserver.post.service;

import com.example.instaserver.post.controller.dto.comment.CommentRequest;
import com.example.instaserver.post.controller.dto.comment.CommentResponse;
import com.example.instaserver.post.entity.Comment;
import com.example.instaserver.post.entity.Post;
import com.example.instaserver.post.repository.CommentRepository;
import com.example.instaserver.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;

    @Transactional
    public CommentResponse write(User user, CommentRequest commentRequest) {
        Assert.notNull(user, "사용자가 존재하지 않습니다.");
        System.out.println(commentRequest.getPostId());
        Assert.notNull(commentRequest.getContent(), "컨텐츠가 존재하지 않습니다.");

        Post post = postService.getPost(commentRequest.getPostId());
        Comment newComment = commentRepository.save(new Comment(user, post, commentRequest.getContent()));
        return CommentResponse.from(newComment);
    }
}