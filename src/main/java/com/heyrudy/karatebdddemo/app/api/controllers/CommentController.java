package com.heyrudy.karatebdddemo.app.api.controllers;

import com.heyrudy.karatebdddemo.app.api.aggregates.dto.CommentDetails;
import com.heyrudy.karatebdddemo.app.api.aggregates.queries.CommentQuery;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommentController {

    CommentQuery commentQuery;

    @GetMapping(value = "/quote")
    @ResponseStatus(code = HttpStatus.OK)
    public CommentDetails getCommentQuote() {
        return commentQuery.getCommentQuote();
    }
}
