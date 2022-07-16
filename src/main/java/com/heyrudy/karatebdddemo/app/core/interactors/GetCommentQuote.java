package com.heyrudy.karatebdddemo.app.core.interactors;

import com.heyrudy.karatebdddemo.app.core.abilities.dbstorage.ICommentStore;
import com.heyrudy.karatebdddemo.app.core.states.Comment;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetCommentQuote {

    ICommentStore iCommentStore;

    public GetCommentQuote(@Qualifier(value = "SpringCommentRepo") ICommentStore iCommentStore) {
        this.iCommentStore = iCommentStore;
    }

    public Comment execute() {
        return iCommentStore.getCommentQuote();
    }
}
