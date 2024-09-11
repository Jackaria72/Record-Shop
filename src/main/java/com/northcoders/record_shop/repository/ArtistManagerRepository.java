package com.northcoders.record_shop.repository;

import com.northcoders.record_shop.model.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistManagerRepository extends CrudRepository<Artist, Long> {
}
