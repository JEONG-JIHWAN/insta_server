package com.example.instaserver.post.service;

import com.example.instaserver.common.exception.NotFoundException;
import com.example.instaserver.post.controller.dto.comment.CommentDeleteDto;
import com.example.instaserver.post.controller.dto.comment.CommentRequest;
import com.example.instaserver.post.controller.dto.comment.CommentResponse;
import com.example.instaserver.post.controller.dto.comment.CommentUpdateRequest;
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
    private final PostService postService;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentResponse write(User user, CommentRequest commentRequest) {
        Assert.notNull(user.getId(), "사용자가 존재하지 않습니다.");
        Post post = postService.getPost(commentRequest.getPostId());
        Comment newComment = commentRepository.save(new Comment(user, post, commentRequest.getContent()));
        return CommentResponse.from(newComment);
    }

    @Transactional
    public CommentResponse update(User user, CommentUpdateRequest commentUpdateRequest) {
        Assert.notNull(user.getId(), "사용자가 존재하지 않습니다.");
        Comment comment = getComment(commentUpdateRequest.getId());
        Assert.isTrue(user.getId() == comment.getUser().getId(), "해당 댓글을 삭제 할 수 없습니다.");
        comment.updateContents(commentUpdateRequest.getContent());
        return CommentResponse.from(comment);
    }

    @Transactional
    public CommentDeleteDto delete(User user, CommentDeleteDto commentDeleteDto) {
        Assert.notNull(user.getId(), "사용자가 존재하지 않습니다.");
        Comment comment = getComment(commentDeleteDto.getId());
        Assert.isTrue(user.getId() == comment.getUser().getId(), "해당 댓글을 삭제 할 수 없습니다.");
        commentRepository.delete(comment);
        return new CommentDeleteDto(commentDeleteDto.getId());
    }

    public Comment getComment(Long commentId){
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundException("해당 게시글을 찾을 수 없습니다."));
    }

}
