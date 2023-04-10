package com.example.instaserver.post.controller;

import com.example.instaserver.auth.CurrentUser;
import com.example.instaserver.post.controller.dto.post.FeedRequest;
import com.example.instaserver.post.controller.dto.post.FeedResponse;
import com.example.instaserver.post.controller.dto.post.PostDeleteRequest;
import com.example.instaserver.post.controller.dto.post.PostDeleteResponse;
import com.example.instaserver.post.controller.dto.post.PostRequest;
import com.example.instaserver.post.controller.dto.post.PostResponse;
import com.example.instaserver.post.controller.dto.post.PostUpdateRequest;
import com.example.instaserver.post.entity.Post;
import com.example.instaserver.post.service.PostService;
import com.example.instaserver.user.entity.User;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class PostController {
    private static final int PAGE_SIZE = 2;
    private final PostService postService;

    @PostMapping(path = "post")
    public PostResponse posting(@CurrentUser User user, @ModelAttribute PostRequest postRequest) throws IOException {
        return postService.write(user, postRequest);
    }

    @PutMapping(path = "post")
    public PostResponse updatePost(@CurrentUser User user, @ModelAttribute PostUpdateRequest postUpdateRequest)
            throws IOException {
        return postService.update(user, postUpdateRequest);
    }

    @DeleteMapping(path = "post")
    public PostDeleteResponse deleteResponse(@CurrentUser User user, @RequestBody PostDeleteRequest postDeleteRequest) {
        return postService.delete(user, postDeleteRequest);
    }

    @GetMapping(path = "feed")
    public FeedResponse feed(@CurrentUser User user, @RequestBody FeedRequest feedRequest,
                             @PageableDefault(size = PAGE_SIZE, sort = "updated_at", direction = Direction.DESC) Pageable pageable) {
        return postService.findPosts(user, feedRequest, pageable);
    }
}
