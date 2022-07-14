package com.heyrudy.karatebdddemo.app.core.interactors;

import com.heyrudy.karatebdddemo.app.core.abilities.fsstorage.IFileStore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ListUploadedFiles {

    IFileStore iFileStore;

    public List<File> execute() {
        return iFileStore.listAll();
    }
}
