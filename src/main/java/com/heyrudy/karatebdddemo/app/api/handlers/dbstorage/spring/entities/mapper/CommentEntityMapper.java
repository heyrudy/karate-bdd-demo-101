package com.heyrudy.karatebdddemo.app.api.handlers.dbstorage.spring.entities.mapper;

import com.heyrudy.karatebdddemo.app.api.handlers.dbstorage.spring.entities.CommentEntity;
import com.heyrudy.karatebdddemo.app.core.states.Comment;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface CommentEntityMapper {

    Comment toComment(CommentEntity entity);
}
