package com.heyrudy.karatebdddemo.app.api.handlers.dbstorage.mock;

import com.heyrudy.karatebdddemo.app.core.abilities.dbstorage.ICommentStore;
import com.heyrudy.karatebdddemo.app.core.states.Comment;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InMemoryCommentStoreImpl implements ICommentStore {

    Map<Long, Comment> inMemoryDb = new HashMap<>();

    @Override
    public Comment getCommentQuote() {
        Comment comment = init();
        return inMemoryDb.get(comment.getId());
    }

    private Comment init() {
        Comment comment = Comment.builder()
                .id(1L)
                .quote("Hello world, use Karate! :)")
                .build();
        inMemoryDb.put(comment.getId(), comment);
        return comment;
    }
}
