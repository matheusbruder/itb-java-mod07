package br.com.mpbruder.tutoriais.service;

import br.com.mpbruder.tutoriais.model.Status;
import br.com.mpbruder.tutoriais.model.Tutorial;
import br.com.mpbruder.tutoriais.repository.TutorialRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) // Vou rodar testes & usar mocks
class TutorialServiceTest {

    @InjectMocks // Quero testar
    private TutorialService service;
    @Mock // Dependência para realizar teste
    private TutorialRepo repo;

    @Test
    void insert_returnNewTutorial_whenTutorialValid() {

        // Arrange
        // Simular a chamada do "repo.save()"
        BDDMockito.when(repo.save(ArgumentMatchers.any(Tutorial.class)))
                .thenReturn(new Tutorial(1L, "Title 1", "Description", Status.DRAFT));

        // Act
        // Testando o método de "insert()" da camada de service
        Tutorial newTutorial = service.insert(new Tutorial(null,"Title 1", "Description", null));

        // Assert
        Assertions.assertThat(newTutorial).isNotNull();
        Assertions.assertThat(newTutorial.getId()).isPositive();
        Assertions.assertThat(newTutorial.getStatus()).isEqualTo(Status.DRAFT);
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void updateById() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByStatusIsPublished() {
    }

    @Test
    void findByTitleContaining() {
    }
}