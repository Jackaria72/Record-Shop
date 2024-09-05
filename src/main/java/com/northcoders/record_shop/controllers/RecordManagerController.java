package com.northcoders.record_shop.controllers;

import com.northcoders.record_shop.service.RecordManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/record")
public class RecordManagerController {

    @Autowired
    RecordManagerService recordManagerService;

}
