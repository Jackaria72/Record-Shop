package com.northcoders.record_shop.service;

import com.northcoders.record_shop.model.Album;
import com.northcoders.record_shop.model.SuperGenre;

import java.util.List;
import java.util.Optional;

public interface RecordManagerService {

    List<Album> getAllAlbums();
    Album getAlbumById(Long id);
    Album insertAlbum(Album record);
    Album updateAlbumById(Album album, Long id);
    void deleteAlbumById(Long id);
    Album assignArtistToAlbum(Long albumId, Long artistId);
    List<Album> getByQuantityInStock(int quantity);
    List<Album> getByGenre(SuperGenre genre);
    List<Album> getByReleaseYear(int year);
    Album getByAlbumName(String albumName);

}
