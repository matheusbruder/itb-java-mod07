package br.com.mpbruder.elastic_example.repository;

import br.com.mpbruder.elastic_example.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepo extends ElasticsearchRepository<Article, Integer> {
}
