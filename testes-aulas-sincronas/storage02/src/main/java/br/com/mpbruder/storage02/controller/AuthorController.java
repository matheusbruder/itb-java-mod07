package br.com.mpbruder.storage02.controller;

import br.com.mpbruder.storage02.model.Author;
import br.com.mpbruder.storage02.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @PostMapping
    public ResponseEntity<Author> insert(@RequestBody Author author) {
        Author newAuthor = service.insert(author);
        return ResponseEntity.ok(newAuthor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable long id) {
        Author author = service.findById(id);
        if (author != null) {
            return ResponseEntity.ok(author);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
