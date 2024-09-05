package com.northcoders.record_shop.service;

import com.northcoders.record_shop.model.RecordModel;

import java.util.List;

public interface RecordManagerService {

    List<RecordModel> getAllRecords();
    RecordModel getRecordById(Long id);
}
