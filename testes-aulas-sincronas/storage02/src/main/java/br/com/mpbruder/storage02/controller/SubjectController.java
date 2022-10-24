package br.com.mpbruder.storage02.controller;

import br.com.mpbruder.storage02.model.Subject;
import br.com.mpbruder.storage02.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @GetMapping("/{id}")
    public ResponseEntity<Subject> findById(@PathVariable long id) {
        Subject subject = service.findById(id);
        if (subject != null) {
            return ResponseEntity.ok(subject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
