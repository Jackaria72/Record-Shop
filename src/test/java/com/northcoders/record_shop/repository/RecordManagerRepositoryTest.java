package com.northcoders.record_shop.repository;

import com.northcoders.record_shop.model.Album;
import com.northcoders.record_shop.model.Artist;
import com.northcoders.record_shop.model.SuperGenre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RecordManagerRepositoryTest {

    @Autowired
    private RecordManagerRepository recordManagerRepository;

    @Test
    public void testFindAllAlbumsReturnsAlbums() {

        // Arrange
        Album record1 = new Album(1L, "Vol.3: The Subliminal Verses", new Artist(1L, "Slipknot",null), SuperGenre.HEAVY_METAL, "Placeholder", "Placeholder", 2004, 3);
        recordManagerRepository.save(record1);

        // Act
        Iterable<Album> records = recordManagerRepository.findAll();

        // Assert
        assertThat(records).hasSize(1);
    }

    @Test
    public void testFindAlbumByIdReturnsAlbum() {
        Album record = new Album(1L, "Vol.3: The Subliminal Verses", new Artist(1L, "Slipknot",null), SuperGenre.HEAVY_METAL, "Placeholder", "Placeholder", 2004, 3);
        recordManagerRepository.save(record);

        Album records = recordManagerRepository.findById(1L).get();

        assertThat(records).isEqualTo(record);
    }
}