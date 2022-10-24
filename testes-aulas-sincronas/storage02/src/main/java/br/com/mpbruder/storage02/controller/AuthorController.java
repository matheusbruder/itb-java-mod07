package br.com.mpbruder.storage02.controller;

import br.com.mpbruder.storage02.dto.AuthorDTO;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<br.com.mpbruder.storage02.dto.AuthorDTO> getById(@PathVariable long id) {
        br.com.mpbruder.storage02.dto.AuthorDTO authorDTO = service.getById(id);
        if (authorDTO != null) {
            return ResponseEntity.ok(authorDTO);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/native/{id}")
    public ResponseEntity<Author> getNativeById(@PathVariable long id) {
        Author author = service.getNativeById(id);
        if (author != null) {
            return ResponseEntity.ok(author);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/dtoeagle/{id}")
    public ResponseEntity<AuthorDTO> getDtoEagle(@PathVariable long id) {
        AuthorDTO authorDTO = service.getDtoEagle(id);
        if (authorDTO != null) {
            return ResponseEntity.ok(authorDTO);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
