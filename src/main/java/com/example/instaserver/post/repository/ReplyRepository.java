package com.example.instaserver.post.repository;

import com.example.instaserver.post.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
