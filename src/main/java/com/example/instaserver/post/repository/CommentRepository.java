package com.example.instaserver.post.repository;

import com.example.instaserver.post.entity.Comment;
import com.example.instaserver.post.entity.Post;
import com.example.instaserver.user.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findById(Long id);

    @Query("select c from Comment c join fetch User u where c.post = :post")
    List<Comment> findWithUserByPost(Post post);
}
