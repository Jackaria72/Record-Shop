package com.northcoders.record_shop.service;

import com.northcoders.record_shop.exception.NotFoundException;
import com.northcoders.record_shop.model.Artist;
import com.northcoders.record_shop.repository.ArtistManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistManagerServiceImpl implements ArtistManagerService {

    @Autowired
    ArtistManagerRepository artistManagerRepository;


    @Override
    public List<Artist> getAllArtists() {
        List<Artist> allArtists = new ArrayList<>();
        artistManagerRepository.findAll().forEach(allArtists::add);
        return allArtists;
    }

    @Override
    public Artist getArtistById(Long id) {
        Optional<Artist> artist = artistManagerRepository.findById(id);
        if (artist.isPresent()) {
            return artist.get();
        } else {
            throw new NotFoundException(String.format("The Artist with the id number '%s' cannot be found!", id));
        }
    }

    @Override
    public Artist insertArtist(Artist artist) {
        return artistManagerRepository.save(artist);
    }
}
