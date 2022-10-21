package br.com.mpbruder.perolas.service;

import br.com.mpbruder.perolas.model.Pearl;
import br.com.mpbruder.perolas.repository.PearlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PearlService implements IPearl {

    @Autowired
    private PearlRepo repository;


    /**
     * Método que cria uma joia e retorna as informações inseridas
     *
     * @param pearl — Objeto joia a ser inserido
     * @return Pearl — objeto inserido
     */
    @Override
    public Pearl insert(Pearl pearl) {
        return repository.save(pearl);
    }

    /**
     * Método que retorna todas as joias
     *
     * @return List<Pearl> — retorna todas as joias
     */
    @Override
    public List<Pearl> findAll() {
        return repository.findAll();
    }

    /**
     * Método que deleta uma joia conforme o Id informado
     *
     * @param id — número de identificação da joia
     */
    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    /**
     * Método que atualiza as informações de uma joia
     *
     * @param pearl — objeto joia a ser inserido
     * @return Pearl — retorna os dados atualizados da joia
     */
    @Override
    public Pearl update(Pearl pearl) {
        return repository.save(pearl);
    }
}
