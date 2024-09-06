package com.northcoders.record_shop.service;

import com.northcoders.record_shop.model.Album;

import java.util.List;

public interface RecordManagerService {

    List<Album> getAllRecords();
    Album getRecordById(Long id);
    Album insertRecord(Album record);
}
