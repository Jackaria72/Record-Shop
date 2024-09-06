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
import java.util.Optional;

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
        recordList.add(new RecordModel(4L, "Enema Of The State", "blink-182", "pop-punk", 1999, 1));

        when(mockRecordManagerRepository.findAll()).thenReturn(recordList);

        List<RecordModel> expectedResult = recordManagerServiceImpl.getAllRecords();

        assertThat(expectedResult).hasSize(4);
        assertThat(expectedResult).isEqualTo(recordList);

    }

    @Test
    void testGetByIdGetsBook() {

        Long id1 = 1L;

        RecordModel test1 = new RecordModel(1L, "Vol.3: The Subliminal Verses", "Slipknot", "nuMetal", 2004, 3);
//        recordList.add(new RecordModel(2L, "Follow the Leader", "Korn", "nuMetal", 1998, 2));
//        recordList.add(new RecordModel(3L, "Nevermind", "Nirvana", "Grunge", 1991, 35));
//        recordList.add(new RecordModel(4L, "Enema Of The State", "blink-182", "pop-punk", 1999, 1));

        when(mockRecordManagerRepository.findById(id1)).thenReturn(Optional.of(test1));

        RecordModel result = recordManagerServiceImpl.getRecordById(id1);

        assertThat(result).isEqualTo(test1);

    }
    @Test
    public void testAddARecord() {

        RecordModel test1 = new RecordModel(1L, "Vol.3: The Subliminal Verses", "Slipknot", "nuMetal", 2004, 3);

        when(mockRecordManagerRepository.save(test1)).thenReturn(test1);

        RecordModel actualResult = recordManagerServiceImpl.insertRecord(test1);

        assertThat(actualResult).isEqualTo(test1);
    }
}