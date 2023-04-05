package com.example.instaserver.post.service;

import com.example.instaserver.common.aws.S3Client;
import com.example.instaserver.post.controller.dto.PostRequest;
import com.example.instaserver.post.controller.dto.PostResponse;
import com.example.instaserver.post.entity.Post;
import com.example.instaserver.post.repository.PostRepository;
import com.example.instaserver.user.entity.User;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final S3Client s3Client;
    @Transactional
    public PostResponse write(User user, PostRequest postRequest) throws IOException {
        Assert.notNull(user.getId(), "사용자가 존재하지 않습니다.");
        Assert.notNull(postRequest.getContent(), "컨텐츠가 존재하지 않습니다.");
        Assert.notNull(postRequest.getImage(), "이미지가 존재하지 않습니다.");

        String postImageUrl = s3Client.uploadImage(postRequest.getImage());
        Post newPost = postRepository.save(new Post(user, postRequest.getContent(), postImageUrl));
        return PostResponse.from(newPost);
    }
}
