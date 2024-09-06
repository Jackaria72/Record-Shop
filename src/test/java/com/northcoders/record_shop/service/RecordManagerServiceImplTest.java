package com.northcoders.record_shop.service;

import com.northcoders.record_shop.model.Album;
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
    void testGetAllAlbumsReturnsListOfAlbums() {
        //Arrange
        List<Album> recordList = new ArrayList<>();
        recordList.add(new Album(1L, "Vol.3: The Subliminal Verses", "Slipknot", "nuMetal", 2004, 3));
        recordList.add(new Album(2L, "Follow the Leader", "Korn", "nuMetal", 1998, 2));
        recordList.add(new Album(3L, "Nevermind", "Nirvana", "Grunge", 1991, 35));
        recordList.add(new Album(4L, "Enema Of The State", "blink-182", "pop-punk", 1999, 1));

        when(mockRecordManagerRepository.findAll()).thenReturn(recordList);

        List<Album> expectedResult = recordManagerServiceImpl.getAllAlbums();

        assertThat(expectedResult).hasSize(4);
        assertThat(expectedResult).isEqualTo(recordList);

    }

    @Test
    void testGetByIdGetsAlbum() {

        Long id1 = 1L;

        Album test1 = new Album(1L, "Vol.3: The Subliminal Verses", "Slipknot", "nuMetal", 2004, 3);
//        recordList.add(new RecordModel(2L, "Follow the Leader", "Korn", "nuMetal", 1998, 2));
//        recordList.add(new RecordModel(3L, "Nevermind", "Nirvana", "Grunge", 1991, 35));
//        recordList.add(new RecordModel(4L, "Enema Of The State", "blink-182", "pop-punk", 1999, 1));

        when(mockRecordManagerRepository.findById(id1)).thenReturn(Optional.of(test1));

        Album result = recordManagerServiceImpl.getAlbumById(id1);

        assertThat(result).isEqualTo(test1);

    }
    @Test
    public void testAddAlbum() {

        Album test1 = new Album(1L, "Vol.3: The Subliminal Verses", "Slipknot", "nuMetal", 2004, 3);

        when(mockRecordManagerRepository.save(test1)).thenReturn(test1);

        Album actualResult = recordManagerServiceImpl.insertAlbum(test1);

        assertThat(actualResult).isEqualTo(test1);
    }
}