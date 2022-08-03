package com.heyrudy.karatebdddemo.app.api.aggregates.dto.mapper;

import com.heyrudy.karatebdddemo.app.api.aggregates.dto.CommentGetDetails;
import com.heyrudy.karatebdddemo.app.core.states.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)
public interface CommentGetDetailsMapper {

    @Mapping(target = "id", ignore = true)
    Comment toComment(CommentGetDetails commentGetDetails);
    CommentGetDetails fromComment(Comment comment);
}
