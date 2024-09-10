package com.northcoders.record_shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Records")
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
    String artist;

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