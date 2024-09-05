package service;

import model.RecordModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RecordManagerRepository;

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
}
