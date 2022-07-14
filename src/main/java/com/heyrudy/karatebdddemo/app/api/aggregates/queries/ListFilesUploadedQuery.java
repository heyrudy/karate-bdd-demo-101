package com.heyrudy.karatebdddemo.app.api.aggregates.queries;

import com.heyrudy.karatebdddemo.app.core.interactors.ListUploadedFiles;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ListFilesUploadedQuery {

    ListUploadedFiles listUploadedFiles;

    public List<File> getUploadedFiles() {
        return listUploadedFiles.execute();
    }
}
