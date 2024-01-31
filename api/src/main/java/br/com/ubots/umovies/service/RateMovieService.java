package br.com.ubots.umovies.service;

import br.com.ubots.umovies.controller.request.RateMovieRequest;
import br.com.ubots.umovies.controller.response.MovieResponse;
import br.com.ubots.umovies.domain.Movie;
import br.com.ubots.umovies.mapper.MovieMapper;
import br.com.ubots.umovies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.ubots.umovies.mapper.MovieMapper.toResponse;

@Service
public class RateMovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private GetMovieService getMovieService;

    @Transactional
    public MovieResponse rate(RateMovieRequest request, Long id){
        Movie movie = getMovieService.byId(id);

        movie.setRating(request.getValue());

        movieRepository.save(movie);

        return toResponse(movie);
    }
}
