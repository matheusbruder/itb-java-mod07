package br.com.mpbruder.storage02.repository;

import br.com.mpbruder.storage02.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepo extends JpaRepository<Author, Long> {
    @Query("select a from Author a where a.id = :id")
    br.com.mpbruder.storage02.dto.AuthorDTO getById(long id);

    @Query(value = "select * from author where id = :id", nativeQuery = true)
    Author getNativeById(long id);

    @Query("select a from Author a left join a.address where a.id = :id")
    br.com.mpbruder.storage02.dto.AuthorDTO getDtoEagle(long id);
}