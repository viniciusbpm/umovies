package br.com.ubots.umovies.service;

import br.com.ubots.umovies.controller.response.MovieResponse;
import br.com.ubots.umovies.mapper.MovieMapper;
import br.com.ubots.umovies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class ListMoviesService {
    @Autowired
    private MovieRepository movieRepository;

    public List<MovieResponse> list(){
        return movieRepository.findAll().stream()
                .map(MovieMapper::toResponse)
                .collect(toList());
    }
}
