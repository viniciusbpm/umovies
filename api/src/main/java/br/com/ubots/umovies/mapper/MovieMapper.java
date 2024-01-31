package br.com.ubots.umovies.mapper;

import br.com.ubots.umovies.controller.request.MovieRequest;
import br.com.ubots.umovies.controller.response.MovieResponse;
import br.com.ubots.umovies.domain.Movie;

public class MovieMapper {
    public static Movie toEntity(MovieRequest request){
        return Movie.builder()
                .title(request.getTitle())
                .synopsis(request.getSynopsis())
                .releaseDate(request.getReleaseDate())
                .build();
    }

    public static MovieResponse toResponse(Movie entity){
        return MovieResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .synopsis(entity.getSynopsis())
                .releaseDate(entity.getReleaseDate())
                .rating(entity.getRating())
                .build();
    }
}
