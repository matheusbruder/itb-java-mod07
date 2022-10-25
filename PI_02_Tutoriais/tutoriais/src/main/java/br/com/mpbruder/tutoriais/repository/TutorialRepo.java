package br.com.mpbruder.tutoriais.repository;

import br.com.mpbruder.tutoriais.model.Status;
import br.com.mpbruder.tutoriais.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepo extends JpaRepository<Tutorial, Long> {

    List<Tutorial> findByStatusIs(Status status);

    List<Tutorial> findByTitleContaining(String title);
}
