package com.heyrudy.karatebdddemo.app.api.aggregates.commands;

import com.heyrudy.karatebdddemo.app.core.interactors.UploadFile;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UploadFileCommand {

    UploadFile uploadFile;

    public Resource uploadFile(String fileName) {
        return uploadFile.execute(fileName);
    }
}
