package br.com.mpbruder.tutoriais.controller;

import br.com.mpbruder.tutoriais.model.Status;
import br.com.mpbruder.tutoriais.model.Tutorial;
import br.com.mpbruder.tutoriais.service.ITutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {
    @Autowired
    private ITutorialService service;

    @PostMapping
    public ResponseEntity<Tutorial> insert(@Valid @RequestBody Tutorial tutorial) {
        var newTutorial = service.insert(tutorial);
        return new ResponseEntity<>(newTutorial, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tutorial>> findAll() {
        List<Tutorial> tutorials = service.findAll();
        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutorial> findById(@PathVariable long id) {
        var tutorial = service.findById(id);
        return new ResponseEntity<>(tutorial, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutorial> updateById(@RequestBody Tutorial tutorial, @PathVariable long id) {
        var updatedTutorial = service.updateById(tutorial, id);
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
    public ResponseEntity<List<Tutorial>> findByStatusIsPublished() {
        List<Tutorial> publishedTutorials = service.findByStatusIsPublished();
        return new ResponseEntity<>(publishedTutorials, HttpStatus.OK);
    }

    @GetMapping("/find_by")
    public ResponseEntity<List<Tutorial>> findByTitleContaining(@RequestParam String title) {
        List<Tutorial> tutorials = service.findByTitleContaining(title);
        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }

    @PatchMapping("/{id}/published")
    public ResponseEntity<Tutorial> updateStatusPublished(@PathVariable long id) {
        var tutorial = service.findById(id);
        tutorial.setStatus(Status.PUBLISHED);
        tutorial = service.updateById(tutorial, tutorial.getId());
        return new ResponseEntity<>(tutorial, HttpStatus.OK);
    }
}
