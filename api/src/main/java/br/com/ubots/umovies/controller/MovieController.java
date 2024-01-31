package br.com.ubots.umovies.controller;

import br.com.ubots.umovies.controller.request.MovieRequest;
import br.com.ubots.umovies.controller.response.MovieResponse;
import br.com.ubots.umovies.service.AddMovieService;
import br.com.ubots.umovies.service.UpdateMovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    private AddMovieService addMovieService;
    @Autowired
    private UpdateMovieService updateMovieService;

    @PostMapping
    public MovieResponse add(@RequestBody @Valid MovieRequest request) {
        return addMovieService.add(request);
    }

    @PutMapping("{id}")
    public MovieResponse update(@RequestBody @Valid MovieRequest request, @PathVariable Long id) {
        return updateMovieService.update(request, id);
    }
}
