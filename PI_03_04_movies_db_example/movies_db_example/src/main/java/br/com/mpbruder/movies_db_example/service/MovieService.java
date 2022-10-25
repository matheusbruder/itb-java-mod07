package br.com.mpbruder.movies_db_example.service;

import br.com.mpbruder.movies_db_example.repository.MovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService implements IMovieService{

    private final MovieRepo repo;

    @Override
    public List<Movie> findAll() {
        return repo.findAll();
    }
}
