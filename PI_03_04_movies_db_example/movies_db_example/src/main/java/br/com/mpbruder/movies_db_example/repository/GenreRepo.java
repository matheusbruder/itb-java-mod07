package br.com.mpbruder.movies_db_example.repository;

import br.com.mpbruder.movies_db_example.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre, Long> {
}
