package com.northcoders.record_shop.service;

import com.northcoders.record_shop.model.Album;

import java.util.List;

public interface RecordManagerService {

    List<Album> getAllAlbums();
    Album getAlbumById(Long id);
    Album insertAlbum(Album record);
    Album updateAlbumById(Album album, Long id);
    void deleteAlbumById(Long id);
    Album assignArtistToAlbum(Long albumId, Long artistId);
    List<Album> getByQuantityInStock(int quantity);

}
