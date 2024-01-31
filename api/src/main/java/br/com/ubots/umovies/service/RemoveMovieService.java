package br.com.ubots.umovies.service;

import br.com.ubots.umovies.domain.Movie;
import br.com.ubots.umovies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveMovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private GetMovieService getMovieService;

    public void remove(Long id){
        Movie movie = getMovieService.byId(id);

        movieRepository.delete(movie);
    }
}
