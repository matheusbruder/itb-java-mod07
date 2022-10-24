package br.com.mpbruder.hql.service;

import br.com.mpbruder.hql.dto.VeiculoPlacaDTO;
import br.com.mpbruder.hql.dto.VeiculoPlacaMarcaDTO;

import java.util.List;

public interface IVeiculoService {

    List<VeiculoPlacaDTO> getAllVeiculoDtoPlaca();

    List<VeiculoPlacaMarcaDTO> getVeiculoDtoPlacaMarcaByAnoFabricacao(int ano_fabricacao);
    List<VeiculoPlacaDTO> getVeiculoDtoPlacaByNmrRodasGreatherThan4AndAnoFabricacaoCurrent();
}
