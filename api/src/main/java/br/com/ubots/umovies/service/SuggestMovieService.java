package br.com.ubots.umovies.service;

import br.com.ubots.umovies.controller.response.MovieResponse;
import br.com.ubots.umovies.domain.Movie;
import br.com.ubots.umovies.mapper.MovieMapper;
import br.com.ubots.umovies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

import static br.com.ubots.umovies.mapper.MovieMapper.toResponse;

@Service
public class SuggestMovieService {
    @Autowired
    private MovieRepository movieRepository;
    public static final int FIRST_POSITION_OF_LIST = 0;

    public MovieResponse suggest(){
        List<Movie> movies = movieRepository.findAllByRatingIsNull();

        Random random = new Random();

        Movie movie = movies.get(random.nextInt(FIRST_POSITION_OF_LIST, movies.size()));

        return toResponse(movie);
    }
}
