package com.northcoders.record_shop.repository;

import com.northcoders.record_shop.model.Album;
import com.northcoders.record_shop.model.SuperGenre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordManagerRepository extends CrudRepository<Album, Long> {
    List<Album> findByQuantityInStockGreaterThan(int quantityInStock);
    List<Album> findByGenreIs(SuperGenre genre);
    List<Album> findByReleaseYearIs(int year);
}
