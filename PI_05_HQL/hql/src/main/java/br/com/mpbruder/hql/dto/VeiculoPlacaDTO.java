package br.com.mpbruder.hql.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VeiculoPlacaDTO {
    private String placa;

    public VeiculoPlacaDTO(String placa) {
        this.placa = placa;
    }


}
