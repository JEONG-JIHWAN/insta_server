package com.example.instaserver.post.service;

import com.example.instaserver.common.aws.S3Client;
import com.example.instaserver.common.exception.NotFoundException;
import com.example.instaserver.follow.repository.FollowRepository;
import com.example.instaserver.post.controller.dto.post.FeedRequest;
import com.example.instaserver.post.controller.dto.post.FeedResponse;
import com.example.instaserver.post.controller.dto.post.PostRequest;
import com.example.instaserver.post.controller.dto.post.PostResponse;
import com.example.instaserver.post.controller.dto.post.PostUpdateRequest;
import com.example.instaserver.post.entity.Post;
import com.example.instaserver.post.repository.PostRepository;
import com.example.instaserver.user.entity.User;
import com.example.instaserver.user.repository.UserRepository;
import jakarta.validation.constraints.AssertTrue;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final S3Client s3Client;
    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    @Transactional
    public PostResponse write(User user, PostRequest postRequest) throws IOException {
        Assert.notNull(user, "사용자가 존재하지 않습니다.");
        Assert.notNull(postRequest.getContent(), "컨텐츠가 존재하지 않습니다.");
        Assert.notNull(postRequest.getImage(), "이미지가 존재하지 않습니다.");

        String postImageUrl = s3Client.uploadImage(postRequest.getImage());
        Post newPost = postRepository.save(new Post(user, postRequest.getContent(), postImageUrl));
        return PostResponse.from(newPost);
    }

    @Transactional
    public PostResponse update(User user, PostUpdateRequest postUpdateRequest) throws IOException {
        Assert.notNull(user, "사용자가 존재하지 않습니다.");
        Assert.notNull(postUpdateRequest.getId(), "수정할 아이디가 존재하지 않습니다.");
        String postImageUrl = s3Client.uploadImage(postUpdateRequest.getImage());
        Post post = getPost(postUpdateRequest.getId());
        Assert.isTrue(user.getId()==post.getUser().getId(), "해당 게시글을 삭제할 수 없습니다.");
        post.update(postUpdateRequest.getContent(), postImageUrl);
        return PostResponse.from(post);
    }

    /**
    @Transactional
    public FeedResponse findPosts(User user, FeedRequest feedRequest) {
        Assert.isTrue(user.getId().equals(feedRequest.getUserId()), "different userId");
        List<User> follower = followRepository.findFollowerByFollowing(user);
        follower.stream().map(f -> postRepository.findAllWithUserByUser(f));
        });

    }
    **/

    public Post getPost(Long postId){
        return postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("게시글을 찾을 수 없습니다."));
    }
}
