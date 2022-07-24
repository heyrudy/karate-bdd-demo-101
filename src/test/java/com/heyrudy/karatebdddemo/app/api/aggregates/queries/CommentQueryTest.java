package com.heyrudy.karatebdddemo.app.api.aggregates.queries;

import com.heyrudy.karatebdddemo.app.api.aggregates.dto.CommentDetails;
import com.heyrudy.karatebdddemo.app.api.aggregates.dto.mapper.CommentDetailsMapper;
import com.heyrudy.karatebdddemo.app.core.interactors.GetCommentQuote;
import com.heyrudy.karatebdddemo.app.core.states.Comment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CommentQueryTest {

    @InjectMocks
    CommentQuery commentQuery;

    @Mock
    GetCommentQuote getCommentQuote;

    @Mock
    CommentDetailsMapper commentDetailsMapper;

    @Test
    @DisplayName(value = "Given a Comment When query Comment quote Then return quote")
    void getCommentQuote() {
        // ARRANGE
        Comment comment = Comment.builder().id(1L).quote("test").build();

        Mockito.when(getCommentQuote.execute()).thenReturn(comment);
        CommentDetails expected = commentDetailsMapper.fromComment(comment);

        // ACT
        CommentDetails actual = commentQuery.getCommentQuote();

        // ASSERT
        Assertions.assertThat(actual)
                .isNotNull();

        Assertions.assertThat(actual.getQuote())
                .isEqualTo(expected.getQuote());
    }
}
