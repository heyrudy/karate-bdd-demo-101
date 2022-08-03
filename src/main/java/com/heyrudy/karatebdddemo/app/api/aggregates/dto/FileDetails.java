package com.heyrudy.karatebdddemo.app.api.aggregates.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.io.File;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileDetails {

    @NotBlank
    String name;

    @PositiveOrZero
    long sizeInBytes;

    public static FileDetails fromFile(File file) {
        return FileDetails.builder()
                .name(file.getName())
                .sizeInBytes(file.length())
                .build();
    }
}
