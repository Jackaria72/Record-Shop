package com.northcoders.record_shop.service;

import com.northcoders.record_shop.model.Artist;

import java.util.List;

public interface ArtistManagerService {

    List<Artist> getAllArtists();
    Artist getArtistById(Long id);
    Artist insertArtist(Artist artist);
    Artist updateArtistById(Long id, Artist artist);
    void deleteArtistById(Long id);

}
