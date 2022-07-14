package com.heyrudy.karatebdddemo.app.core.interactors;

import com.heyrudy.karatebdddemo.app.core.abilities.fsstorage.IFileStore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UploadFile {

    IFileStore iFileStore;

    public Resource execute(String fileName) {
        return iFileStore.load(fileName);
    }
}
