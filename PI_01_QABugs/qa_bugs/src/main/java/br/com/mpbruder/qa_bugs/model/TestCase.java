package br.com.mpbruder.qa_bugs.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_case;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean tested;

    @Column(nullable = false)
    private boolean passed;

    @Column(nullable = false)
    private int number_of_tries;

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
    private Date last_update;

}
