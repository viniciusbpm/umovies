package br.com.ubots.umovies.controller;

import br.com.ubots.umovies.controller.request.MovieRequest;
import br.com.ubots.umovies.controller.response.MovieResponse;
import br.com.ubots.umovies.service.AddMovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    private AddMovieService addMovieService;

    @PostMapping
    public MovieResponse add(@RequestBody @Valid MovieRequest request) {
        return addMovieService.add(request);
    }
}
