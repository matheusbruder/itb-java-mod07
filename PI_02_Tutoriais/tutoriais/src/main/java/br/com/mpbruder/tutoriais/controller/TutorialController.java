package br.com.mpbruder.tutoriais.controller;

import br.com.mpbruder.tutoriais.model.Tutorial;
import br.com.mpbruder.tutoriais.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

    @Autowired
    private TutorialService service;

    @PostMapping
    public ResponseEntity<Tutorial> insert(@RequestBody Tutorial tutorial) {
        Tutorial newTutorial = service.insert(tutorial);
        return new ResponseEntity<>(newTutorial, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tutorial>> findAll() {
        List<Tutorial> tutorials = service.findAll();
        return new ResponseEntity<>(tutorials, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutorial> findById(@PathVariable long id) {
        Tutorial tutorial = service.findById(id);
        return new ResponseEntity<>(tutorial, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutorial> updateById(@RequestBody Tutorial tutorial, @PathVariable long id) {
        Tutorial updatedTutorial = service.updateById(tutorial, id);
        return new ResponseEntity<>(updatedTutorial, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        service.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/published")
    public ResponseEntity<List<Tutorial>> getPublishedTutorials() {
        List<Tutorial> publishedTutorials = service.getPublishedTutorials();
        return new ResponseEntity<>(publishedTutorials, HttpStatus.OK);
    }

    @GetMapping("/bytitle")
    public ResponseEntity<List<Tutorial>> getTutorialByTitle(@RequestParam String title) {
        List<Tutorial> tutorials = service.getTutorialByTitle(title);
        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }
}
