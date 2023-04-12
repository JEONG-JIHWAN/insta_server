package com.example.instaserver.post.repository;

import com.example.instaserver.post.entity.Comment;
import com.example.instaserver.post.entity.Reply;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    Optional<Reply> findById(Long id);
}
