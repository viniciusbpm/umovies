package br.com.ubots.umovies.controller.response;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieResponse {
    private Long id;
    private String title;
    private String synopsis;
    private LocalDate releaseDate;
    private Long rating;
}
