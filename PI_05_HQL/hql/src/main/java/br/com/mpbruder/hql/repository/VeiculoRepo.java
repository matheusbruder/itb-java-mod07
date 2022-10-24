package br.com.mpbruder.hql.repository;

import br.com.mpbruder.hql.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface VeiculoRepo extends JpaRepository<Veiculo, Long> {

    @Query("select v from Veiculo v where v.ano_fabricacao = :ano_fabricacao")
    List<Veiculo> getVeiculoDtoPlacaMarcaByAnoFabricacao(@Param("ano_fabricacao") int ano_fabricacao);

    @Query("select v from Veiculo v where v.nmr_rodas > 4 and v.ano_fabricacao = year(current_date)")
    List<Veiculo> getVeiculoDtoPlacaByNmrRodasGreatherThan4AndAnoFabricacaoCurrent();

}
