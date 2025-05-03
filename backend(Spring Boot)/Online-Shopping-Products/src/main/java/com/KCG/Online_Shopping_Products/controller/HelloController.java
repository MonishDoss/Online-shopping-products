package com.KCG.Online_Shopping_Products.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/greet")
    public String greet(@ParameterObject String name) {
        return "Hello, " + name + "!";
    }
}
