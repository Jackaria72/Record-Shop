package com.northcoders.record_shop.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ArtistManagerRepositoryTest {

    @Autowired
    private ArtistManagerRepository artistManagerRepository;


}
