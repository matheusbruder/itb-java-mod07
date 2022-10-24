package br.com.mpbruder.hql.service;

import br.com.mpbruder.hql.dto.VeiculoPlacaDTO;
import br.com.mpbruder.hql.dto.VeiculoPlacaMarcaDTO;
import br.com.mpbruder.hql.model.Veiculo;
import br.com.mpbruder.hql.repository.VeiculoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService implements IVeiculoService {

    private final VeiculoRepo repo;

    @Override
    public List<VeiculoPlacaDTO> getAllVeiculoDtoPlaca() {
        List<VeiculoPlacaDTO> veiculoDTOS = new ArrayList<>();

        List<Veiculo> veiculos = repo.findAll();
        for (Veiculo v : veiculos) {
            veiculoDTOS.add(new VeiculoPlacaDTO(v.getPlaca()));
        }
        return veiculoDTOS;
    }

    @Override
    public List<VeiculoPlacaMarcaDTO> getVeiculoDtoPlacaMarcaByAnoFabricacao(int ano_fabricacao) {
        List<VeiculoPlacaMarcaDTO> veiculoDTOS = new ArrayList<>();

        List<Veiculo> veiculos = repo.getVeiculoDtoPlacaMarcaByAnoFabricacao(ano_fabricacao);
        for (Veiculo v : veiculos) {
            veiculoDTOS.add(new VeiculoPlacaMarcaDTO(v.getPlaca(), v.getMarca()));
        }
        return veiculoDTOS;
    }

    @Override
    public List<VeiculoPlacaDTO> getVeiculoDtoPlacaByNmrRodasGreatherThan4AndAnoFabricacaoCurrent() {
        List<VeiculoPlacaDTO> veiculoDTOS = new ArrayList<>();

        List<Veiculo> veiculos = repo.getVeiculoDtoPlacaByNmrRodasGreatherThan4AndAnoFabricacaoCurrent();
        for (Veiculo v : veiculos) {
            veiculoDTOS.add(new VeiculoPlacaDTO(v.getPlaca()));
        }
        return veiculoDTOS;
    }
}
