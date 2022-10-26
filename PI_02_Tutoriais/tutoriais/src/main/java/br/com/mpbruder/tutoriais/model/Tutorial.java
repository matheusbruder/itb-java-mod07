package br.com.mpbruder.tutoriais.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title must not be blank")
    @Column(length = 50, nullable = false)
    private String title;

    @Size(min = 10, max = 100)
    @Column(length = 100)
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

}
