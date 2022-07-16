package com.heyrudy.karatebdddemo.app.core.interactors;

import com.heyrudy.karatebdddemo.app.core.abilities.dbstorage.ICommentStore;
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
class GetCommentQuoteTest {

    @InjectMocks
    GetCommentQuote getCommentQuote;

    @Mock
    ICommentStore iCommentStore;

    @Test
    @DisplayName(value = "Get comment quote")
    void execute() {
        // ARRANGE
        Comment expected = Comment.builder().id(1L).quote("test").build();

        Mockito.when(iCommentStore.getCommentQuote()).thenReturn(expected);

        // ACT
        Comment actual = getCommentQuote.execute();

        // ASSERT
        Assertions.assertThat(actual)
                .isNotNull();

        Assertions.assertThat(actual.getQuote())
                .isEqualTo(expected.getQuote());
    }
}
