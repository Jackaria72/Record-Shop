package com.northcoders.record_shop.service;

import com.northcoders.record_shop.model.Artist;

import java.util.List;

public interface ArtistManagerService {

    List<Artist> getAllArtists();
    Artist getArtistById(Long id);

}
