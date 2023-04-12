package com.example.instaserver.post.repository;

import com.example.instaserver.post.entity.Post;
import com.example.instaserver.user.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
    Optional<Post> findById(Long id);

}
