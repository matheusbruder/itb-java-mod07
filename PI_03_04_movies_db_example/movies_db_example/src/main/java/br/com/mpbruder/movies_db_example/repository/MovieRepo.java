package br.com.mpbruder.movies_db_example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, Long> {
}
