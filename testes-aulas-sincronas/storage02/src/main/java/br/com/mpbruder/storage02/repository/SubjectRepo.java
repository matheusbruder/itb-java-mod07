package br.com.mpbruder.storage02.repository;

import br.com.mpbruder.storage02.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
}
