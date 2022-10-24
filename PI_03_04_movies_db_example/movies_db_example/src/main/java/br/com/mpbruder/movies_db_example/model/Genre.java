package br.com.mpbruder.movies_db_example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    private long id;
    private Date created_at;
    private Date updated_at;
    private String name;
    private int ranking;
    private int active;

    @OneToMany(mappedBy = "genre")
    @JsonIgnoreProperties("genre")
    private List<Movie> movies;
}
