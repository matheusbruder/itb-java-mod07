package br.com.mpbruder.storage02.repository;

import br.com.mpbruder.storage02.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}