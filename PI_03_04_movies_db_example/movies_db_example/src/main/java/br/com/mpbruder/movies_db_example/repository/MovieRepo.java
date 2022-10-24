package br.com.mpbruder.movies_db_example.repository;

import br.com.mpbruder.movies_db_example.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, Long> {
}
