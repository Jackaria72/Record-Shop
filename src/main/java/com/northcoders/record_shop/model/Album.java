package com.northcoders.record_shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Album")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public @Data class Album {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;

    @Column
    String albumName;

    @Column
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    Artist artist;

    @Column
    @Enumerated(EnumType.STRING)
    SuperGenre genre;

    @Column
    String albumArt;

    @Column
    String trackList;

    @Column
    int releaseYear;

    @Column
    int quantityInStock;
}