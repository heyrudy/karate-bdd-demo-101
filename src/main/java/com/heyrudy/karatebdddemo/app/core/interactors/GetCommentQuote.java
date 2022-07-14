package com.heyrudy.karatebdddemo.app.core.interactors;

import com.heyrudy.karatebdddemo.app.core.abilities.dbstorage.ICommentStore;
import com.heyrudy.karatebdddemo.app.core.states.Comment;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetCommentQuote {

    ICommentStore iCommentStore;

    public Comment execute() {
        return iCommentStore.getCommentQuote();
    }
}
