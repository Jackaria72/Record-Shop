package com.northcoders.record_shop.service;

import com.northcoders.record_shop.repository.RecordManagerRepository;
import com.northcoders.record_shop.model.RecordModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordManagerServiceImpl implements RecordManagerService {

    @Autowired
    RecordManagerRepository recordManagerRepository;

    @Override
    public List<RecordModel> getAllRecords() {
        List<RecordModel> allRecords = new ArrayList<>();
        recordManagerRepository.findAll().forEach(allRecords::add);
        return allRecords;
    }

    @Override
    public RecordModel getRecordById(Long id) {
        return null;
    }
}
