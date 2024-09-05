package com.northcoders.record_shop.service;

import com.northcoders.record_shop.repository.RecordManagerRepository;
import com.northcoders.record_shop.model.RecordModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<RecordModel> record = recordManagerRepository.findById(id);
        if (record.isPresent()) {
            return record.get();
        } else {
            throw new RuntimeException(String.format("The record with the id number '%s' cannot be found!", id));
        }


    }
}
