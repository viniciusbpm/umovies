package br.com.ubots.umovies.repository;

import br.com.ubots.umovies.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByRatingIsNull();
}
