package com.example.instaserver.post.entity;

import com.example.instaserver.common.entity.BaseEntity;
import com.example.instaserver.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;

@Entity
@Getter
public class Post extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String contents;
    private String profileImageUrl;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    public Post(User user, String contents, String profileImageUrl) {
        this.user = user;
        this.contents = contents;
        this.profileImageUrl = profileImageUrl;
    }

}
