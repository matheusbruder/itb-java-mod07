package br.com.mpbruder.hql.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Sinistro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date data;
    private double perda_economica;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    @JsonIgnoreProperties("sinistros")
    private Veiculo veiculo;
}
