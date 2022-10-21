package br.com.mpbruder.storage01.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity // Indica que a classe será persistida no BD como uma tabela
@Table(name = "table_user") // Nome dado a tabela no banco de dados (opcional)
public class UserBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cod;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(name = "e_mail", length = 100, unique = true)
    private String email;
}
