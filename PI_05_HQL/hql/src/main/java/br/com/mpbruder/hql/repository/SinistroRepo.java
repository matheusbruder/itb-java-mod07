package br.com.mpbruder.hql.repository;

import br.com.mpbruder.hql.model.Sinistro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinistroRepo extends JpaRepository<Sinistro, Long> {
}
