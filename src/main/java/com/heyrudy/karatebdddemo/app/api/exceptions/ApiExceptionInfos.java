package com.heyrudy.karatebdddemo.app.api.exceptions;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class ApiExceptionInfos {
    String message;
    HttpStatus status;
}
