package com.northcoders.record_shop.service;

import com.northcoders.record_shop.model.Album;
import com.northcoders.record_shop.model.Artist;
import com.northcoders.record_shop.repository.ArtistManagerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
class ArtistManagerServiceImplTest {

    @Mock
    private ArtistManagerRepository mockArtistManagerRepository;

    @InjectMocks
    private ArtistManagerServiceImpl mockArtistManagerService;

    @Test
    void testGetAllArtistsReturnsAllArtists() {
        Set<Album> albums = new HashSet<>();
        List<Artist> artistList = new ArrayList<>();
        artistList.add(new Artist(1L, "Slipknot", albums));
        artistList.add(new Artist(2L, "Korn", albums));
        artistList.add(new Artist(3L, "Nirvana", albums));
        artistList.add(new Artist(4L, "blink-182", albums));

        when(mockArtistManagerRepository.findAll()).thenReturn(artistList);

        List<Artist> result = mockArtistManagerService.getAllArtists();

        assertThat(result).hasSize(4);
        assertThat(result).isEqualTo(artistList);

    }
    @Test
    void testGetByIdGetsArtist() {
        Set<Album> albums = new HashSet<>();
        Long id1 = 1L;
        Artist test1 = new Artist(1L, "Slipknot", albums);

        when(mockArtistManagerRepository.findById(id1)).thenReturn(Optional.of(test1));

        Artist result = mockArtistManagerService.getArtistById(id1);

        assertThat(result).isEqualTo(test1);
    }
    @Test
    void testAddArtist() {
        Set<Album> albums = new HashSet<>();
        Artist test1 = new Artist(1L, "Slipknot", albums);

        when(mockArtistManagerRepository.save(test1)).thenReturn(test1);

        Artist result = mockArtistManagerService.insertArtist(test1);

        assertThat(result).isEqualTo(test1);
    }

}