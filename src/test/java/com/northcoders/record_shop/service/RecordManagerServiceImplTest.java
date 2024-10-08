package com.northcoders.record_shop.service;

import com.northcoders.record_shop.exception.NotFoundException;
import com.northcoders.record_shop.model.Album;
import com.northcoders.record_shop.model.Artist;
import com.northcoders.record_shop.model.SuperGenre;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.northcoders.record_shop.repository.RecordManagerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

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
        recordList.add(new Album(1L, "Vol.3: The Subliminal Verses", new Artist(1L, "Slipknot",null), SuperGenre.HEAVY_METAL,"Placeholder", "Placeholder", 2004, 3));
        recordList.add(new Album(2L, "Follow the Leader", new Artist(2L, "Korn", null), SuperGenre.HEAVY_METAL, "Placeholder", "Placeholder",  1998, 2));
        recordList.add(new Album(3L, "Nevermind", new Artist(3L, "Nirvana", null), SuperGenre.ALT_ROCK_AND_INDIE, "Placeholder", "Placeholder", 1991, 35));
        recordList.add(new Album(4L, "Enema Of The State", new Artist(4L, "blink-182", null), SuperGenre.PUNK_WAVE, "Placeholder", "Placeholder", 1999, 1));

        when(mockRecordManagerRepository.findAll()).thenReturn(recordList);

        List<Album> expectedResult = recordManagerServiceImpl.getAllAlbums();

        assertThat(expectedResult).hasSize(4);
        assertThat(expectedResult).isEqualTo(recordList);

    }

    @Test
    void testGetByIdGetsAlbum() {

        Long id1 = 1L;

        Album test1 = new Album(1L, "Vol.3: The Subliminal Verses", new Artist(1L, "Slipknot",null), SuperGenre.HEAVY_METAL,"Placeholder", "Placeholder",  2004, 3);
//        recordList.add(new RecordModel(2L, "Follow the Leader", "Korn", "nuMetal", 1998, 2));
//        recordList.add(new RecordModel(3L, "Nevermind", "Nirvana", "Grunge", 1991, 35));
//        recordList.add(new RecordModel(4L, "Enema Of The State", "blink-182", "pop-punk", 1999, 1));

        when(mockRecordManagerRepository.findById(id1)).thenReturn(Optional.of(test1));

        Album result = recordManagerServiceImpl.getAlbumById(id1);

        assertThat(result).isEqualTo(test1);

    }
    @Test
    public void testGetById_WhereIdNotFound() {
        Long id = 1L;


        when(mockRecordManagerRepository.findById(id)).thenThrow(new NotFoundException(String.format("The Album with the id number '%s' cannot be found!", id)));



        assertThrows(NotFoundException.class, () -> recordManagerServiceImpl.getAlbumById(id));
        verify(mockRecordManagerRepository, times(1)).findById(id);
        verifyNoMoreInteractions(mockRecordManagerRepository);
    }
    @Test
    public void testAddAlbum() {

        Album test1 = new Album(1L, "Vol.3: The Subliminal Verses", new Artist(1L, "Slipknot",null), SuperGenre.HEAVY_METAL, "Placeholder", "Placeholder", 2004, 3);

        when(mockRecordManagerRepository.save(test1)).thenReturn(test1);

        Album actualResult = recordManagerServiceImpl.insertAlbum(test1);

        assertThat(actualResult).isEqualTo(test1);
    }
    @Test
    public void testUpdateAlbum() {
        Long id = 1L;
        Album test1 = new Album(1L, "Vol.3: The Subliminal Verses", new Artist(1L, "Slipknot",null), SuperGenre.HEAVY_METAL, "Placeholder", "Placeholder", 2004, 3);

        when(mockRecordManagerRepository.findById(id)).thenReturn(Optional.of(test1));
        when(mockRecordManagerRepository.save(test1)).thenReturn(test1);

        Album result = recordManagerServiceImpl.updateAlbumById(test1, id);

        assertThat(result).isEqualTo(test1);

    }
    @Test
    public void testForDeleteAlbum() {
        Long testId = 1L;
        Album test1 = new Album(1L, "Vol.3: The Subliminal Verses", new Artist(1L, "Slipknot",null), SuperGenre.HEAVY_METAL, "Placeholder", "Placeholder", 2004, 3);

        when(mockRecordManagerRepository.findById(testId)).thenReturn(Optional.of(test1));
        doNothing().when(mockRecordManagerRepository).deleteById(testId);

        recordManagerServiceImpl.deleteAlbumById(testId);

        verify(mockRecordManagerRepository, times(1)).deleteById(testId);
    }
}