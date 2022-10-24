package br.com.mpbruder.tutoriais.repository;

import br.com.mpbruder.tutoriais.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TutorialRepo extends JpaRepository<Tutorial, Long> {

    @Query("select t from Tutorial t where t.isPublished is true")
    List<Tutorial> getPublishedTutorials();

    @Query("select t from Tutorial t where t.title like %:title%")
    List<Tutorial> getTutorialByTitle(@Param("title") String title);
}
