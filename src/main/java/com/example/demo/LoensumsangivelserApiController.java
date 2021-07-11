package com.example.demo;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
@PropertySource("errormsg.properties")

public class LoensumsangivelserApiController implements LoensumsangivelserApi {

    @Override
    public ResponseEntity<Object> httpRequest(
            @Pattern(regexp = "[0-9]{3}") @Valid @RequestParam(value = "CustomQueryParameter", required = false) String customQueryParameter) {
        return null;
    }

}
