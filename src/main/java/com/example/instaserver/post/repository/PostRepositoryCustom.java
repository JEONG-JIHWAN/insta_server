package com.example.instaserver.post.repository;

import com.example.instaserver.post.entity.Post;
import com.example.instaserver.user.entity.User;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface PostRepositoryCustom {

    Slice<Post> findAll(Long cursorId, List<User> follower, Pageable pageable);
}
