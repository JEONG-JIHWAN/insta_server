package com.example.instaserver.post.entity;

import com.example.instaserver.common.entity.BaseEntity;
import com.example.instaserver.post.controller.dto.post.PostUpdateRequest;
import com.example.instaserver.user.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private String contents;
    private String profileImageUrl;
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    public Post(User user, String contents, String profileImageUrl) {
        this.user = user;
        this.contents = contents;
        this.profileImageUrl = profileImageUrl;
    }


    public void update(String contents, String profileImageUrl) {
        this.contents = contents;
        this.profileImageUrl = profileImageUrl;
    }

}
