package com.heyrudy.karatebdddemo.app.api.controllers;

import com.heyrudy.karatebdddemo.app.api.aggregates.dto.RequestDetails;
import com.heyrudy.karatebdddemo.app.api.aggregates.dto.ResultDetails;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class NameTransformationController {

    @PostMapping(value = "/name")
    @ResponseStatus(code = HttpStatus.OK)
    public ResultDetails getNameLength(@Valid @RequestBody RequestDetails requestDetails) {
        String nameLengthAsString = String.valueOf(requestDetails.getName().length());

        return ResultDetails.builder()
                .length(nameLengthAsString)
                .build();
    }
}
