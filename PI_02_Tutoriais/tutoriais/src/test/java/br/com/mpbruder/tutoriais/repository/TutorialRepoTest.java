package br.com.mpbruder.tutoriais.repository;

import br.com.mpbruder.tutoriais.model.Status;
import br.com.mpbruder.tutoriais.model.Tutorial;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@DataJpaTest // Preciso que carregue o ambiente JPA para utilizar os métodos que utilizam o banco!
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TutorialRepoTest {

    @Autowired
    private TutorialRepo repo;

    @BeforeEach
    public void setup() {
        repo.deleteAll();
    }

    @Test
    void save_returnTutorial_whenTutorialIsValid() {
        // Arrange
        Tutorial newTutorial = new Tutorial(null, "Title1", "Description1", Status.DRAFT);
        // Act
        Tutorial tutorialSaved = repo.save(newTutorial);
        // Assert
        Assertions.assertThat(tutorialSaved).isNotNull();
        Assertions.assertThat(tutorialSaved.getId()).isPositive();
        Assertions.assertThat(tutorialSaved.getStatus()).isEqualTo(Status.DRAFT);
        Assertions.assertThat(tutorialSaved.getTitle()).isEqualTo(newTutorial.getTitle());
    }

    @Test
    void findById_returnTutorial_whenIdTutorialExists() {
        // Arrange
        Tutorial newTutorial = new Tutorial(null, "Title1", "Description1", Status.DRAFT);
        Tutorial tutorialSaved = repo.save(newTutorial);
        // Act
        Optional<Tutorial> optionalTutorial = repo.findById(tutorialSaved.getId());
        //Assert
        Assertions.assertThat(optionalTutorial).isPresent();
        Assertions.assertThat(optionalTutorial.get().getId()).isPositive();
        Assertions.assertThat(optionalTutorial.get().getStatus()).isEqualTo(newTutorial.getStatus());
        Assertions.assertThat(optionalTutorial.get().getTitle()).isEqualTo(newTutorial.getTitle());
    }

    @Test
    void findById_returnOptionalEmpty_whenIdTutorialNotExists() {
        // Arrange

        // Act
        Optional<Tutorial> optionalTutorial = repo.findById(1L);
        //Assert
        Assertions.assertThat(optionalTutorial).isEmpty();
    }

    @Test
    void findByTitle_returnListTutorials_whenTitleExists() {
        // Arrange
        Tutorial newTutorial = new Tutorial(null, "Title1", "Description1", Status.DRAFT);
        Tutorial tutorialSaved = repo.save(newTutorial);
        // Act
        List<Tutorial> tutorials = repo.findByTitleContaining("title");
        // Assert
        Assertions.assertThat(tutorials).hasSize(1);
        Assertions.assertThat(tutorials.get(0).getId()).isEqualTo(tutorialSaved.getId());
    }

    @Test
    void findByTitle_returnEmptyList_whenTitleNotExists() {
        // Arrange
        Tutorial newTutorial = new Tutorial(null, "Title1", "Description1", Status.DRAFT);
        Tutorial tutorialSaved = repo.save(newTutorial);
        // Act
        List<Tutorial> tutorials = repo.findByTitleContaining("Tutorial");
        // Assert
        Assertions.assertThat(tutorials).isEmpty();
    }
}
