package com.example.instaserver.post.repository;

import static com.example.instaserver.post.entity.QPost.post;

import com.example.instaserver.post.entity.Post;
import com.example.instaserver.post.entity.QPost;
import com.example.instaserver.user.entity.User;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public Slice<Post> findAll(Long cursorId, List<User> followers, Pageable pageable) {
        QPost post = QPost.post;
        List<Post> results = jpaQueryFactory
                .select(post)
                .from(post)
                .join(post.user)
                .fetchJoin()
                .where(post.user.in(followers))
                .where(eqCursorId(cursorId))
                .limit(pageable.getPageSize())
                .fetch();

        return new SliceImpl<>(results);
    }

    private BooleanExpression eqCursorId(Long cursorId) {
        if (cursorId != null) {
            return post.id.gt(cursorId);
        }
        return null;
    }

}
