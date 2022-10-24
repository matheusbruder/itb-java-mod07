package br.com.mpbruder.hql.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VeiculoPlacaMarcaModeloDTO {
    private String placa;
    private String marca;
    private String modelo;


    public VeiculoPlacaMarcaModeloDTO(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }
}
