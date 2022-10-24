package br.com.mpbruder.hql.controller;

import br.com.mpbruder.hql.dto.VeiculoPlacaDTO;
import br.com.mpbruder.hql.dto.VeiculoPlacaMarcaDTO;
import br.com.mpbruder.hql.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @GetMapping("/placas")
    public ResponseEntity<List<VeiculoPlacaDTO>> getAllVeiculoDtoPlaca() {
        List<VeiculoPlacaDTO> veiculoDTOS = service.getAllVeiculoDtoPlaca();
        return new ResponseEntity<>(veiculoDTOS, HttpStatus.OK);
    }

    @GetMapping("/{ano_fabricacao}")
    public ResponseEntity<List<VeiculoPlacaMarcaDTO>> getVeiculoDtoPlacaMarcaByAnoFabricacao(@PathVariable int ano_fabricacao){
        List<VeiculoPlacaMarcaDTO> veiculoDTOS = service.getVeiculoDtoPlacaMarcaByAnoFabricacao(ano_fabricacao);
        return new ResponseEntity<>(veiculoDTOS, HttpStatus.OK);
    }

    @GetMapping("/nro_rodas4&ano_fabricacao_current")
    public ResponseEntity<List<VeiculoPlacaDTO>> getVeiculoDtoPlacaByNmrRodasGreatherThan4AndAnoFabricacaoCurrent() {
        List<VeiculoPlacaDTO> veiculoDTOS = service.getVeiculoDtoPlacaByNmrRodasGreatherThan4AndAnoFabricacaoCurrent();
        return new ResponseEntity<>(veiculoDTOS, HttpStatus.OK);
    }
}
