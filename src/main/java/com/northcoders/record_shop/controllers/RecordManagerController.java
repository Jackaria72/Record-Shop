package com.northcoders.record_shop.controllers;

import com.northcoders.record_shop.model.Album;
import com.northcoders.record_shop.service.RecordManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/album")
public class RecordManagerController {

    @Autowired
    RecordManagerService recordManagerService;

    @GetMapping("/all-albums")
    public ResponseEntity<List<Album>> getAllAlbums() {
        List<Album> records = recordManagerService.getAllAlbums();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id) {
        Album record = recordManagerService.getAlbumById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Album> addAlbum(@RequestBody Album record) {
        Album newRecord = recordManagerService.insertAlbum(record);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("album", "/api/v1/album" + newRecord.getId().toString());
        return new ResponseEntity<>(newRecord, httpHeaders, HttpStatus.CREATED);
    }

}
