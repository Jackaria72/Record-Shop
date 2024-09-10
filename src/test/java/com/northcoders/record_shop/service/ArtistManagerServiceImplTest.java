package com.northcoders.record_shop.service;

import com.northcoders.record_shop.repository.ArtistManagerRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ArtistManagerServiceImplTest {

    @Mock
    private ArtistManagerRepository mockArtistManagerRepository;

    @InjectMocks
    private ArtistManagerServiceImpl mockArtistManagerService;



}