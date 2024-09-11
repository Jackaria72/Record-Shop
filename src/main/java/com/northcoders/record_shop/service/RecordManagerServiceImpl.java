package com.northcoders.record_shop.service;

import com.northcoders.record_shop.exception.NotFoundException;
import com.northcoders.record_shop.model.Artist;
import com.northcoders.record_shop.repository.ArtistManagerRepository;
import com.northcoders.record_shop.repository.RecordManagerRepository;
import com.northcoders.record_shop.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecordManagerServiceImpl implements RecordManagerService {

    @Autowired
    RecordManagerRepository recordManagerRepository;

    @Autowired
    ArtistManagerRepository artistManagerRepository;

    @Override
    public List<Album> getAllAlbums() {
        List<Album> allRecords = new ArrayList<>();
        recordManagerRepository.findAll().forEach(allRecords::add);
        return allRecords;
    }

    @Override
    public Album getAlbumById(Long id) {
        Optional<Album> record = recordManagerRepository.findById(id);
        if (record.isPresent()) {
            return record.get();
        } else {
            throw new NotFoundException(String.format("The Album with the id number '%s' cannot be found!", id));
        }


    }

    @Override
    public Album insertAlbum(Album record) {
        return recordManagerRepository.save(record);
    }

    @Override
    public Album updateAlbumById(Album album, Long id) {
        Optional<Album> original = recordManagerRepository.findById(id);
        if (original.isPresent()) {
            Album update =original.get();
            update.setAlbumName(album.getAlbumName());
            update.setArtist(album.getArtist());
            update.setGenre(album.getGenre());
            update.setAlbumArt(album.getAlbumArt());
            update.setTrackList(album.getTrackList());
            update.setReleaseYear(album.getReleaseYear());
            update.setQuantityInStock(album.getQuantityInStock());

            return recordManagerRepository.save(update);
        } else {
            throw new NotFoundException(String.format("The Album with the id number '%s' cannot be found!", id));
        }
    }

    @Override
    public void deleteAlbumById(Long id) {
        Optional<Album> album = recordManagerRepository.findById(id);
        if (album.isPresent()) {
            recordManagerRepository.deleteById(id);
        } else {
            throw new NotFoundException(String.format("The Album with the id number '%s' cannot be found!", id));
        }
    }

    @Override
    public Album assignArtistToAlbum(Long albumId, Long artistId) {
        Optional<Album> optAlbum = recordManagerRepository.findById(albumId);
        Optional<Artist> optArtist = artistManagerRepository.findById(artistId);
        if (optAlbum.isEmpty()) {
            throw new NotFoundException(String.format("The Album with the id number '%s' cannot be found!", albumId));
        }
        if (optArtist.isEmpty()) {
            throw new NotFoundException(String.format("The Artist with the id number '%s' cannot be found!", artistId));
        }
        Album album = optAlbum.get();
        Artist artist = optArtist.get();
        album.assignArtist(artist);
        return recordManagerRepository.save(album);
    }
}
