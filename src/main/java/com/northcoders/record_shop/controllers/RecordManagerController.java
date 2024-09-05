package com.northcoders.record_shop.controllers;

import com.northcoders.record_shop.model.RecordModel;
import com.northcoders.record_shop.service.RecordManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/record")
public class RecordManagerController {

    @Autowired
    RecordManagerService recordManagerService;

    @GetMapping("/all-records")
    public ResponseEntity<List<RecordModel>> getAllRecords() {
        List<RecordModel> records = recordManagerService.getAllRecords();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

}
