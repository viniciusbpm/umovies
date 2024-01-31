package br.com.ubots.umovies.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MovieRequest {
    @NotBlank(message = "You have to add a title to the movie")
    private String title;
    @NotBlank(message = "You have to add a synopsis to the movie")
    private String synopsis;
    @NotNull(message = "You have to add a release date to the movie")
    private LocalDate releaseDate;
}
