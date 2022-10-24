package br.com.mpbruder.storage02.repository;

import br.com.mpbruder.storage02.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {
}