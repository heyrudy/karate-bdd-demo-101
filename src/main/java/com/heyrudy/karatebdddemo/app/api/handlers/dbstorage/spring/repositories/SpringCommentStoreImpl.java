package com.heyrudy.karatebdddemo.app.api.handlers.dbstorage.spring.repositories;

import com.heyrudy.karatebdddemo.app.api.handlers.dbstorage.spring.entities.CommentEntity;
import com.heyrudy.karatebdddemo.app.api.handlers.dbstorage.spring.entities.mapper.CommentEntityMapper;
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
public class SpringCommentStoreImpl implements ICommentStore {

    @PersistenceContext
    EntityManager em;
    CommentEntityMapper commentEntityMapper;

    @Override
    public Comment getCommentQuote() {
        String getCommentQuoteNamedQuery = "Comment.getFirstCommentQuote";
        CommentEntity commentEntity = em.createNamedQuery(getCommentQuoteNamedQuery, CommentEntity.class)
                .getSingleResult();
        em.close();
        return commentEntityMapper.toComment(commentEntity);
    }
}
