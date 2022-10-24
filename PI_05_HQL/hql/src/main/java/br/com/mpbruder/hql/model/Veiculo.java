package br.com.mpbruder.hql.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String placa;
    private String marca;
    private String modelo;
    private int ano_fabricacao;
    private int nmr_rodas;

    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("veiculo")
    private List<Sinistro> sinistros;
}
