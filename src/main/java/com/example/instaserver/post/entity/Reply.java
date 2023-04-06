package com.example.instaserver.post.entity;

import com.example.instaserver.common.entity.BaseEntity;
import com.example.instaserver.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;
    private String contents;

    public Reply(User user, Comment comment, String contents) {
        this.user = user;
        this.comment = comment;
        this.contents = contents;
    }

    public void updateContents(String contents) {
        this.contents = contents;
    }
}
