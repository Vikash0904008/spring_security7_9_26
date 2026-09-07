package com.vikash.green.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellowcontroller {

    @GetMapping({"/", "/hi", "/api/hi"})
    public String hi() {
        return "HI";
    }
}

