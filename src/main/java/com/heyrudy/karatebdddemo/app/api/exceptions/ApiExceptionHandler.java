package com.heyrudy.karatebdddemo.app.api.exceptions;

import com.heyrudy.karatebdddemo.app.core.abilities.dbstorage.exceptions.DbInteractionException;
import com.heyrudy.karatebdddemo.app.core.abilities.fsstorage.exceptions.FsInteractionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.io.FileNotFoundException;
import java.util.Optional;

@ControllerAdvice
public final class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(final ApiRequestException apiRequestException) {
        ApiExceptionInfos apiExceptionInfos = ApiExceptionInfos.builder()
                .message(apiRequestException.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return new ResponseEntity<>(apiExceptionInfos, apiExceptionInfos.getStatus());
    }

    @ExceptionHandler(value = {DbInteractionException.class})
    public ResponseEntity<Object> handleDbRequestException(final DbInteractionException dbInteractionException) {
        ApiExceptionInfos apiExceptionInfos = ApiExceptionInfos.builder()
                .message(dbInteractionException.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return new ResponseEntity<>(apiExceptionInfos, apiExceptionInfos.getStatus());
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseEntity<Object> handleHttpMessageNotReadableException(final HttpMessageNotReadableException httpMessageNotReadableException) {
        String message = Optional.ofNullable(httpMessageNotReadableException.getMessage())
                .map(exceptionMessage -> exceptionMessage.split(":")[0])
                .orElse("");
        ApiExceptionInfos apiExceptionInfos = ApiExceptionInfos.builder()
                .message(message)
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return new ResponseEntity<>(apiExceptionInfos, apiExceptionInfos.getStatus());
    }

    @ExceptionHandler(value = {FileNotFoundException.class, FsInteractionException.class})
    public ResponseEntity<Object> handleFsStorageFileNotFound() {
        return ResponseEntity.notFound()
                .build();
    }

    @ExceptionHandler(value = {MaxUploadSizeExceededException.class})
    public ResponseEntity<Object> handleMaxSizeException() {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new FsInteractionException("File too large!"));
    }
}
