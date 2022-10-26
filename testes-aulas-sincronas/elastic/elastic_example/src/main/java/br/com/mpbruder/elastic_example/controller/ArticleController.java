package br.com.mpbruder.elastic_example.controller;

import br.com.mpbruder.elastic_example.model.Article;
import br.com.mpbruder.elastic_example.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private IArticleService service;

    @PostMapping
    public ResponseEntity<Article> insert(@RequestBody Article article) {
        return new ResponseEntity<>(service.save(article), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Article>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> findById(@PathVariable int id) {
        Optional<Article> optionalArticle = service.findById(id);
        if (optionalArticle.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalArticle.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Article deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Article> update(@RequestBody Article article) {
        return new ResponseEntity<>(service.update(article), HttpStatus.OK);
    }

}
