package br.com.mpbruder.movies_db_example.service;

import br.com.mpbruder.movies_db_example.model.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> findAll();
}
