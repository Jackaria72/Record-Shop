package com.northcoders.record_shop.controllers;

import com.northcoders.record_shop.model.Artist;
import com.northcoders.record_shop.service.ArtistManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
