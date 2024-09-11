package com.northcoders.record_shop.repository;

import com.northcoders.record_shop.model.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordManagerRepository extends CrudRepository<Album, Long> {
    List<Album> findByQuantityInStockGreaterThan(int quantityInStock);

}
