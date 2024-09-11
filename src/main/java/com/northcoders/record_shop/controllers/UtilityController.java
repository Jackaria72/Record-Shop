package com.northcoders.record_shop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class UtilityController {

    @GetMapping("/home")
    public ResponseEntity<String> getHomeGreeting() {
        String greeting = "Hello Welcome to our RecordShop!";
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
