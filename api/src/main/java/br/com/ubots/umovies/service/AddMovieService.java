package br.com.ubots.umovies.service;

import br.com.ubots.umovies.controller.request.MovieRequest;
import br.com.ubots.umovies.controller.response.MovieResponse;
import br.com.ubots.umovies.domain.Movie;
import br.com.ubots.umovies.mapper.MovieMapper;
import br.com.ubots.umovies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.ubots.umovies.mapper.MovieMapper.toEntity;
import static br.com.ubots.umovies.mapper.MovieMapper.toResponse;

@Service
public class AddMovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    public MovieResponse add(MovieRequest request){
        Movie movie = toEntity(request);

        movieRepository.save(movie);

        return toResponse(movie);
    }
}
