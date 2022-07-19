package com.heyrudy.karatebdddemo.app.api.aggregates.queries;

import com.heyrudy.karatebdddemo.app.api.aggregates.dto.CommentDetails;
import com.heyrudy.karatebdddemo.app.core.abilities.dbstorage.exceptions.DbInteractionException;
import com.heyrudy.karatebdddemo.app.core.interactors.GetCommentQuote;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommentQuery {

    GetCommentQuote getCommentQuote;

    public CommentDetails getCommentQuote() {
        return Optional.ofNullable(getCommentQuote.execute())
                .map(CommentDetails::fromComment)
                .orElseThrow(() -> new DbInteractionException("comment is not found"));
    }
}
