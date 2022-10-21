package br.com.mpbruder.storage01.repository;

import br.com.mpbruder.storage01.model.UserBD;
import org.springframework.data.repository.CrudRepository;

// CRUD = Create, Read, Update & Delete
public interface UserRepo extends CrudRepository<UserBD, Long> {

}
