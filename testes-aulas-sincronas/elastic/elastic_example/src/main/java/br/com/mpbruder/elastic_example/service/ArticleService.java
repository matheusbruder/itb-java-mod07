package br.com.mpbruder.elastic_example.service;

import br.com.mpbruder.elastic_example.model.Article;
import br.com.mpbruder.elastic_example.repository.ArticleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService implements IArticleService {

    private final ArticleRepo repo;

    @Override
    public Article save(Article article) {
        return repo.save(article);
    }
}
