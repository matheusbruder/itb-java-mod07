package br.com.mpbruder.elastic_example.controller;

import br.com.mpbruder.elastic_example.model.Article;
import br.com.mpbruder.elastic_example.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private IArticleService service;

    @PostMapping
    public ResponseEntity<Article> insert(@RequestBody Article article) {
        return new ResponseEntity<>(service.save(article), HttpStatus.CREATED);
    }
}
