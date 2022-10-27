package br.com.mpbruder.elastic_example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(indexName = "blog")
public class Article {
    @Id
    private int id;
    private String title;

    // Atributo || Coluna
    // FieldType.Nested => encadeado, aninhado
    // includeInParent = true =>
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Author> authors;
}
