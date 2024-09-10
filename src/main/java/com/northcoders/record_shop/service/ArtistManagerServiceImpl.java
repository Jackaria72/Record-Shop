package com.northcoders.record_shop.service;

import com.northcoders.record_shop.model.Artist;
import com.northcoders.record_shop.repository.ArtistManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
