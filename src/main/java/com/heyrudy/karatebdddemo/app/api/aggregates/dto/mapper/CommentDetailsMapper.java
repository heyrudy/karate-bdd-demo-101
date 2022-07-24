package com.heyrudy.karatebdddemo.app.api.aggregates.dto.mapper;

import com.heyrudy.karatebdddemo.app.api.aggregates.dto.CommentDetails;
import com.heyrudy.karatebdddemo.app.core.states.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)
public interface CommentDetailsMapper {

    @Mapping(target = "id", ignore = true)
    Comment toComment(CommentDetails commentDetails);
    CommentDetails fromComment(Comment comment);
}
