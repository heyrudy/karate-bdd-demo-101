package com.heyrudy.karatebdddemo.app.core.states;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment {

    Long id;
    String quote;

}
