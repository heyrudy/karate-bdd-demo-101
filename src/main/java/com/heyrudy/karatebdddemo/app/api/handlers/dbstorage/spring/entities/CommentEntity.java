package com.heyrudy.karatebdddemo.app.api.handlers.dbstorage.spring.entities;

import com.heyrudy.karatebdddemo.app.core.states.Comment;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "COMMENT")
@NamedQueries(
        @NamedQuery(
                name = "Comment.getFirstCommentQuote",
                query = "SELECT c FROM CommentEntity c WHERE c.id = 1"
        )
)
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String quote;

    public Comment toComment() {
        return Comment.builder()
                .id(this.getId())
                .quote(this.getQuote())
                .build();
    }
}
