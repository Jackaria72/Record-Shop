package com.northcoders.record_shop.controllers;

import com.northcoders.record_shop.service.ArtistManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/artist")
public class ArtistManagerController {

    @Autowired
    ArtistManagerService artistManagerService;


}
