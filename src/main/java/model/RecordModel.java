package model;

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
public @Data class RecordModel {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;

    @Column
    String albumName;

    @Column
    String description;

    @Column
    String artist;

    @Column
    String genre;

    @Column
    int releaseYear;

    @Column
    int quantityInStock;
}