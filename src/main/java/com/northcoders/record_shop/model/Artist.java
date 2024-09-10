package com.northcoders.record_shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Artists")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public @Data class Artist {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;

    @Column
    String artistName;

    @JsonIgnore
    @OneToMany(mappedBy = "artists")
    Set<Album> albums = new HashSet<>();
}
