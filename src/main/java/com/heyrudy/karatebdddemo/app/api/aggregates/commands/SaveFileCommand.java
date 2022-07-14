package com.heyrudy.karatebdddemo.app.api.aggregates.commands;

import com.heyrudy.karatebdddemo.app.core.interactors.SaveFile;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SaveFileCommand {

    SaveFile saveFile;

    public void saveFile(MultipartFile file) {
        saveFile.execute(file);
    }
}
