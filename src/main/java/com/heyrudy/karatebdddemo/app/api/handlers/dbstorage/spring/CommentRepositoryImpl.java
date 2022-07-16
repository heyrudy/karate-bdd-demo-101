package com.heyrudy.karatebdddemo.app.api.handlers.dbstorage.spring;

import com.heyrudy.karatebdddemo.app.api.handlers.dbstorage.spring.entities.CommentEntity;
import com.heyrudy.karatebdddemo.app.core.abilities.dbstorage.ICommentStore;
import com.heyrudy.karatebdddemo.app.core.states.Comment;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Primary
@Component(value = "SpringCommentRepo")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommentRepositoryImpl implements ICommentStore {

    @PersistenceContext
    EntityManager em;

    @Override
    public Comment getCommentQuote() {
        String getCommentQuoteNamedQuery = "Comment.getFirstCommentQuote";
        Comment comment = em.createNamedQuery(getCommentQuoteNamedQuery, CommentEntity.class)
                .getSingleResult()
                .fromCommentEntity();
        em.close();
        return comment;
    }
}
