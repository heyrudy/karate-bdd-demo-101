package com.heyrudy.karatebdddemo.app.api.aggregates.queries;

import com.heyrudy.karatebdddemo.app.api.aggregates.dto.CommentGetDetails;
import com.heyrudy.karatebdddemo.app.api.aggregates.dto.mapper.CommentGetDetailsMapper;
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
    CommentGetDetailsMapper commentGetDetailsMapper;

    public CommentGetDetails getCommentQuote() {
        Comment comment = getCommentQuote.execute();
        return commentGetDetailsMapper.fromComment(comment);
    }
}
