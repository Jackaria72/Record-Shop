package com.northcoders.record_shop.service;

import com.northcoders.record_shop.model.RecordModel;
import com.northcoders.record_shop.service.RecordManagerServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.northcoders.record_shop.repository.RecordManagerRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@DataJpaTest
class RecordManagerServiceImplTest {

    @Mock
    private RecordManagerRepository mockRecordManagerRepository;

    @InjectMocks
    private RecordManagerServiceImpl recordManagerServiceImpl;

    @Test
    void testGetAllRecordsReturnsListOfRecords() {
        //Arrange
        List<RecordModel> recordList = new ArrayList<>();
        recordList.add(new RecordModel(1L, "Vol.3: The Subliminal Verses", "Slipknot", "nuMetal", 2004, 3));
        recordList.add(new RecordModel(2L, "Follow the Leader", "Korn", "nuMetal", 1998, 2));
        recordList.add(new RecordModel(3L, "Nevermind", "Nirvana", "Grunge", 1991, 35));
        recordList.add(new RecordModel(1L, "Enema Of The State", "blink-182", "pop-punk", 1999, 1));

        when(mockRecordManagerRepository.findAll()).thenReturn(recordList);

        List<RecordModel> expectedResult = recordManagerServiceImpl.getAllRecords();

        assertThat(expectedResult).hasSize(4);
        assertThat(expectedResult).isEqualTo(recordList);

    }
}