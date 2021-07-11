package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
@Validated
public interface LoensumsangivelserApi {
    @GetMapping(
        value = "/endpointurl",
        produces = { "application/json" }
    )
    default ResponseEntity<Object> httpRequest(@Pattern(regexp="[0-9]{3}") @Valid @RequestParam(value = "CustomQueryParameter", required = false) String customQueryParameter) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
