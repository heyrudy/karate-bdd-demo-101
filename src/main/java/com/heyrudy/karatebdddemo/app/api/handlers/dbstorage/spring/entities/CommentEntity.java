package com.heyrudy.karatebdddemo.app.api.handlers.dbstorage.spring.entities;

import com.heyrudy.karatebdddemo.app.core.states.Comment;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

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
