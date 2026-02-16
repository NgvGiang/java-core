package org.example.javacore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilmDto {
    private Long id;

    private String title;

    private String description;

    private Integer releaseYear;

    private String language;

    private String originalLanguage;

    private Byte rentalDuration;

    private BigDecimal rentalRate;

    private Short length;

    private BigDecimal replacementCost;

    private String rating;

    private String specialFeatures;

    private Instant lastUpdate;

}
