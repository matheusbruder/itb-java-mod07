package br.com.mpbruder.movies_db_example.controller;

import br.com.mpbruder.movies_db_example.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
        List<Movie> movies = service.findAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}
