package br.com.mpbruder.perolas.service;

import br.com.mpbruder.perolas.model.Pearl;

import java.util.List;

public interface IPearl {

    /**
     * Método que cria uma joia e retorna as informações inseridas
     *
     * @param pearl — objeto joia a ser inserido
     * @return Pearl — objeto inserido
     */
    Pearl insert(Pearl pearl);

    /**
     * Método que retorna todas as joias
     *
     * @return List<Pearl> — retorna todas as joias
     */
    List<Pearl> findAll();

    /**
     * Método que deleta uma joia conforme o Id informado
     *
     * @param id — número de identificação da joia
     */
    void delete(long id);

    /**
     * Método que atualiza as informações de uma joia
     *
     * @param pearl — objeto joia a ser inserido
     * @return Pearl — retorna os dados atualizados da joia
     */
    Pearl update(Pearl pearl);
}
