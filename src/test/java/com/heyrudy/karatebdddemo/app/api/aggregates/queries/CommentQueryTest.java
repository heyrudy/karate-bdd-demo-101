package com.heyrudy.karatebdddemo.app.api.aggregates.queries;

import com.heyrudy.karatebdddemo.app.api.aggregates.dto.CommentGetDetails;
import com.heyrudy.karatebdddemo.app.api.aggregates.dto.mapper.CommentGetDetailsMapper;
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
    CommentGetDetailsMapper commentGetDetailsMapper;

    @Test
    @DisplayName(value = "Given a Comment When query Comment quote Then return quote")
    void getCommentQuote() {
        // ARRANGE
        Comment comment = Comment.builder().id(1L).quote("test").build();

        Mockito.when(getCommentQuote.execute()).thenReturn(comment);
        CommentGetDetails expected = commentGetDetailsMapper.fromComment(comment);

        // ACT
        CommentGetDetails actual = commentQuery.getCommentQuote();

        // ASSERT
        Assertions.assertThat(actual)
                .isNotNull();

        Assertions.assertThat(actual.getQuote())
                .isEqualTo(expected.getQuote());
    }
}
