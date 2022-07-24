package com.heyrudy.karatebdddemo.app.api.aggregates.queries;

import com.heyrudy.karatebdddemo.app.api.aggregates.dto.CommentDetails;
import com.heyrudy.karatebdddemo.app.api.aggregates.dto.mapper.CommentDetailsMapper;
import com.heyrudy.karatebdddemo.app.core.interactors.GetCommentQuote;
import com.heyrudy.karatebdddemo.app.core.states.Comment;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommentQuery {

    GetCommentQuote getCommentQuote;
    CommentDetailsMapper commentDetailsMapper;

    public CommentDetails getCommentQuote() {
        Comment comment = getCommentQuote.execute();
        return commentDetailsMapper.fromComment(comment);
    }
}
