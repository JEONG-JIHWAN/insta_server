package com.example.instaserver.post.repository;

import com.example.instaserver.post.entity.Comment;
import com.example.instaserver.post.entity.Reply;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Query("select r from Reply r join fetch User u where r.comment = :comment")
    List<Reply> findAllWithUserByComment(Comment comment);
}
