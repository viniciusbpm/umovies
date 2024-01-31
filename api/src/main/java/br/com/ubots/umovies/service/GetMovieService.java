package br.com.ubots.umovies.service;

import br.com.ubots.umovies.domain.Movie;
import br.com.ubots.umovies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class GetMovieService {
    @Autowired
    private MovieRepository movieRepository;
    public static final String MOVIE_DOES_NOT_EXIST_MESSAGE = "Movie not found";

    public Movie byId(Long id){
        Optional<Movie> movie = movieRepository.findById(id);

        if(movie.isEmpty()){
            throw new ResponseStatusException(BAD_REQUEST, MOVIE_DOES_NOT_EXIST_MESSAGE);
        }

        return movie.get();
    }
}
