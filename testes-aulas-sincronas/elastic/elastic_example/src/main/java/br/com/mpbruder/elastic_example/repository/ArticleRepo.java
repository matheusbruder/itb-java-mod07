package br.com.mpbruder.elastic_example.repository;

import br.com.mpbruder.elastic_example.model.Article;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ArticleRepo extends ElasticsearchRepository<Article, Integer> {
    @Query("{" +
            "\"match_all\":{}\n" +
            "}")
    List<Article> findAll();
}
