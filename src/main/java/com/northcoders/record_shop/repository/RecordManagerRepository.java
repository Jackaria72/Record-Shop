package com.northcoders.record_shop.repository;

import com.northcoders.record_shop.model.RecordModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordManagerRepository extends CrudRepository<RecordModel, Long> {
}
