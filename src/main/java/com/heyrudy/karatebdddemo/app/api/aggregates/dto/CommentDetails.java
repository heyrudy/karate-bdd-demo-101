package com.heyrudy.karatebdddemo.app.api.aggregates.dto;

import com.heyrudy.karatebdddemo.app.core.states.Comment;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentDetails {

    String quote;

    public Comment toComment() {
        return Comment.builder()
                .quote(this.getQuote())
                .build();
    }

    public static CommentDetails fromComment(final Comment comment) {
        return CommentDetails.builder()
                .quote(comment.getQuote())
                .build();
    }
}
