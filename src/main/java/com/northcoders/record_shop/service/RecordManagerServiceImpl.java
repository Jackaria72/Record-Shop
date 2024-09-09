package com.northcoders.record_shop.service;

import com.northcoders.record_shop.exception.NotFoundException;
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
        Album original = getAlbumById(id);
        if (original != null) {
            original.setAlbumName(album.getAlbumName());
            original.setArtist(album.getArtist());
            original.setGenre(album.getGenre());
            original.setReleaseYear(album.getReleaseYear());
            original.setQuantityInStock(album.getQuantityInStock());

            return recordManagerRepository.save(original);
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
}
