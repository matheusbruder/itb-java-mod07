package br.com.mpbruder.hql.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VeiculoPlacaMarcaDTO {
    private String placa;
    private String marca;

    public VeiculoPlacaMarcaDTO(String placa, String marca) {
        this.placa = placa;
        this.marca = marca;
    }
}
