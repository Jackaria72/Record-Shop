package com.northcoders.record_shop.controllers;

import com.northcoders.record_shop.model.Artist;
import com.northcoders.record_shop.service.ArtistManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/artist")
public class ArtistManagerController {

    @Autowired
    ArtistManagerService artistManagerService;

    @GetMapping("/all-artists")
    public ResponseEntity<List<Artist>> getAllArtists() {
        List<Artist> artists = artistManagerService.getAllArtists();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id) {
        Artist artist = artistManagerService.getArtistById(id);
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Artist> addArtist(@RequestBody Artist artist) {
        Artist newArtist = artistManagerService.insertArtist(artist);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("artist", "/api/v1/artist" + newArtist.getId().toString());
        return new ResponseEntity<>(newArtist, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Long id, @RequestBody Artist artist) {
        Artist update = artistManagerService.updateArtistById(id, artist);
        return new ResponseEntity<>(update, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Artist> deleteArtistById(@PathVariable Long id) {
        artistManagerService.deleteArtistById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
