package br.com.ubots.umovies.controller;

import br.com.ubots.umovies.controller.request.MovieRequest;
import br.com.ubots.umovies.controller.request.RateMovieRequest;
import br.com.ubots.umovies.controller.response.MovieResponse;
import br.com.ubots.umovies.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    private AddMovieService addMovieService;
    @Autowired
    private UpdateMovieService updateMovieService;
    @Autowired
    private ListMoviesService listMoviesService;
    @Autowired
    private RemoveMovieService removeMovieService;
    @Autowired
    private RateMovieService rateMovieService;
    @Autowired
    private SuggestMovieService suggestMovieService;


    @PostMapping
    public MovieResponse add(@RequestBody @Valid MovieRequest request) {
        return addMovieService.add(request);
    }

    @PutMapping("{id}")
    public MovieResponse update(@Valid @RequestBody MovieRequest request, @PathVariable Long id) {
        return updateMovieService.update(request, id);
    }

    @GetMapping
    public List<MovieResponse> list() {
        return listMoviesService.list();
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable Long id) {
        removeMovieService.remove(id);
    }

    @PutMapping("rate/{id}")
    public MovieResponse rate(@Valid @RequestBody RateMovieRequest request, @PathVariable Long id){
        return rateMovieService.rate(request, id);
    }

    @GetMapping("suggest")
    public MovieResponse suggest(){
        return suggestMovieService.suggest();
    }

}
