package br.com.mpbruder.tutoriais.controller;

import br.com.mpbruder.tutoriais.model.Status;
import br.com.mpbruder.tutoriais.model.Tutorial;
import br.com.mpbruder.tutoriais.service.TutorialService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TutorialController.class)
class TutorialControllerTest {

    @Autowired
    private MockMvc mockMvc; // Ajuda com requisições

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean // Mock cujo gerenciamento é feito pelo próprio spring
    private TutorialService service;


    @Test
    void insert_returnNewTutorial_whenTutorialIsValid() throws Exception {
        // Arrange
        BDDMockito.when(service.insert(ArgumentMatchers.any(Tutorial.class)))
                .thenReturn(new Tutorial(1L, "Title 1", "Description 1", Status.DRAFT));

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