package com.northcoders.record_shop.repository;

import com.northcoders.record_shop.model.RecordModel;
import com.northcoders.record_shop.repository.RecordManagerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RecordManagerRepositoryTest {

    @Autowired
    private RecordManagerRepository recordManagerRepository;

    @Test
    public void testFindAllRecordModelReturnsRecordModel() {

        // Arrange
        RecordModel record1 = new RecordModel(1L, "Vol.3: The Subliminal Verses", "Slipknot", "nuMetal", 2004, 3);
        recordManagerRepository.save(record1);

        // Act
        Iterable<RecordModel> records = recordManagerRepository.findAll();

        // Assert
        assertThat(records).hasSize(1);
    }

    @Test
    public void testFindRecordByIdReturnsRecord() {
        RecordModel record = new RecordModel(1L, "Vol.3: The Subliminal Verses", "Slipknot", "nuMetal", 2004, 3);
        recordManagerRepository.save(record);

        RecordModel records = recordManagerRepository.findById(1L).get();

        assertThat(records).isEqualTo(record);
    }
}