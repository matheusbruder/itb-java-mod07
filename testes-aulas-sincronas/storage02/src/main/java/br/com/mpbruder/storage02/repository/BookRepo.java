package br.com.mpbruder.storage02.repository;

import br.com.mpbruder.storage02.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
