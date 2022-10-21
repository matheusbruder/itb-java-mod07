package br.com.mpbruder.perolas.repository;

import br.com.mpbruder.perolas.model.Pearl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PearlRepo extends JpaRepository<Pearl, Long> {
}
