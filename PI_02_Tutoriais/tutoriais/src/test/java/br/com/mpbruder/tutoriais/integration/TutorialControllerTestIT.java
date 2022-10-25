package br.com.mpbruder.tutoriais.integration;

import br.com.mpbruder.tutoriais.controller.TutorialController;
import br.com.mpbruder.tutoriais.model.Status;
import br.com.mpbruder.tutoriais.model.Tutorial;
import br.com.mpbruder.tutoriais.repository.TutorialRepo;
import br.com.mpbruder.tutoriais.service.TutorialService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
class TutorialControllerTestIT {

    @Autowired
    private MockMvc mockMvc; // Ajuda com requisições

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TutorialRepo repo;

    @BeforeEach
    public void setup() {
        repo.deleteAll();
    }


    @Test
    void insert_returnNewTutorial_whenTutorialIsValid() throws Exception {
        // Arrange
        Tutorial tutorial = new Tutorial(null, "Title 1", "Description 1", null);

        // Act
        ResultActions result = mockMvc.perform(post("/api/tutorials")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tutorial))
        );

        // Assert
        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.title", CoreMatchers.is("Title 1")));
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

    @Test
    void updateStatusPublished() {
    }
}