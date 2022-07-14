package com.heyrudy.karatebdddemo.app.core.interactors;

import com.heyrudy.karatebdddemo.app.core.abilities.fsstorage.IFileStore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SaveFile {

    IFileStore iFileStore;

    public void execute(MultipartFile file) {
        iFileStore.save(file);
    }
}
