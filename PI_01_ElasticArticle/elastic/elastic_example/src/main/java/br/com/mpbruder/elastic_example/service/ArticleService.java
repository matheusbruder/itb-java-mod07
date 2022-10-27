package br.com.mpbruder.elastic_example.service;

import br.com.mpbruder.elastic_example.model.Article;
import br.com.mpbruder.elastic_example.repository.ArticleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService implements IArticleService {

    private final ArticleRepo repo;

    @Override
    public Article save(Article article) {
        return repo.save(article);
    }

    @Override
    public List<Article> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Article> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public Article update(Article article) {
        return repo.save(article);
    }
}
