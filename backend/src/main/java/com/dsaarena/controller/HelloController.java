package com.dsaarena.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/test")
    public String test() {
        return "DSA Arena Backend is running!";
    }
}