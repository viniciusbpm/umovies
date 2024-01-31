package br.com.ubots.umovies.service;

import br.com.ubots.umovies.controller.request.MovieRequest;
import br.com.ubots.umovies.controller.response.MovieResponse;
import br.com.ubots.umovies.domain.Movie;
import br.com.ubots.umovies.mapper.MovieMapper;
import br.com.ubots.umovies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.ubots.umovies.mapper.MovieMapper.toResponse;

@Service
public class UpdateMovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private GetMovieService getMovieService;

    @Transactional
    public MovieResponse update(MovieRequest request, Long id){
        Movie movie = getMovieService.byId(id);

        movie.setTitle(request.getTitle());
        movie.setSynopsis(request.getSynopsis());
        movie.setReleaseDate(request.getReleaseDate());

        movieRepository.save(movie);

        return toResponse(movie);
    }
}
