package com.example.instaserver.post.repository;

import com.example.instaserver.post.entity.Post;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    public Optional<Post> findById(Long id);
}
