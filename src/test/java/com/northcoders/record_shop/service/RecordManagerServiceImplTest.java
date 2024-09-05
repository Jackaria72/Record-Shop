package com.northcoders.record_shop.service;

import com.northcoders.record_shop.service.RecordManagerServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.northcoders.record_shop.repository.RecordManagerRepository;

@DataJpaTest
class RecordManagerServiceImplTest {

    @Mock
    private RecordManagerRepository recordManagerRepository;

    @InjectMocks
    private RecordManagerServiceImpl recordManagerServiceImpl;

    @Test
    void getAllRecords() {
    }
}