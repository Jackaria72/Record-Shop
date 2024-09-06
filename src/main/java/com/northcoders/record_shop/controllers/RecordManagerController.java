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
@RequestMapping("/api/v1/record")
public class RecordManagerController {

    @Autowired
    RecordManagerService recordManagerService;

    @GetMapping("/all-records")
    public ResponseEntity<List<Album>> getAllRecords() {
        List<Album> records = recordManagerService.getAllRecords();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Album> getRecordById(@PathVariable Long id) {
        Album record = recordManagerService.getRecordById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Album> addBook(@RequestBody Album record) {
        Album newRecord = recordManagerService.insertRecord(record);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("record", "/api/v1/record" + newRecord.getId().toString());
        return new ResponseEntity<>(newRecord, httpHeaders, HttpStatus.CREATED);
    }

}
