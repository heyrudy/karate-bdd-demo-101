package com.heyrudy.karatebdddemo.app.api.controllers;

import com.heyrudy.karatebdddemo.app.api.aggregates.commands.SaveFileCommand;
import com.heyrudy.karatebdddemo.app.api.aggregates.dto.FileDetails;
import com.heyrudy.karatebdddemo.app.api.aggregates.queries.ListFilesUploadedQuery;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FileUploadController {

    ListFilesUploadedQuery listFilesUploadedQuery;
    SaveFileCommand saveFileCommand;

    @GetMapping("/files")
    @ResponseBody
    public ResponseEntity<List<FileDetails>> listFiles() {
        List<FileDetails> filesDetails = listFilesUploadedQuery.getUploadedFiles().stream()
                .map(FileDetails::fromFile)
                .collect(Collectors.toList());

        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(filesDetails);
    }

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> handleFileUpload(@RequestParam(value = "fileUpload") MultipartFile file) {
        saveFileCommand.saveFile(file);

        Map<String, Object> response = Map.ofEntries(
                Map.entry("error", false),
                Map.entry("bytesUploaded", file.getSize())
        );

        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
