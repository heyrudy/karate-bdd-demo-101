package com.heyrudy.karatebdddemo.app.api.handlers.fsstorage.mock;

import com.heyrudy.karatebdddemo.app.core.abilities.fsstorage.IFileStore;
import com.heyrudy.karatebdddemo.app.core.abilities.fsstorage.exceptions.FsInteractionException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocalFileStoreImpl implements IFileStore {

    Path temporaryUploadPath;

    @Autowired
    public void initProperty(@Value(value = "${upload.path.name}") String temporaryUploadPathName) {
        this.temporaryUploadPath = Paths.get(temporaryUploadPathName);
    }

    @Override
    public void init() {
        try {
            Files.createDirectory(temporaryUploadPath);
        } catch (IOException e) {
            throw new FsInteractionException("Could not initialize folder for uploadFile!");
        }
    }

    @Override
    public void save(MultipartFile file) {
        Optional.ofNullable(file.getOriginalFilename())
                .ifPresent(filename -> {
                    try {
                        Files.copy(file.getInputStream(), temporaryUploadPath.resolve(filename));
                    } catch (IOException e) {
                        throw new FsInteractionException(String.format("Could not store the file. Error: %s", e.getMessage()));
                    }
                });
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = temporaryUploadPath.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FsInteractionException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new FsInteractionException(String.format("Error: %s", e.getMessage()));
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(temporaryUploadPath.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try (Stream<Path> stream = Files.walk(temporaryUploadPath, 1)) {
            return stream
                    .filter(path -> !temporaryUploadPath.equals(path))
                    .map(temporaryUploadPath::relativize);
        } catch (IOException e) {
            throw new FsInteractionException("Could not load the files!");
        }
    }

    @Override
    public List<File> listAll() {
        try (Stream<Path> stream = Files.list(temporaryUploadPath)) {
            return stream
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new FsInteractionException("Could not list all files!");
        }
    }
}
